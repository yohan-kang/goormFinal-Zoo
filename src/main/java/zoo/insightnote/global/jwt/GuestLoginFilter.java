package zoo.insightnote.global.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import zoo.insightnote.global.oauth2.dto.CustomUserDetails;
import zoo.insightnote.domain.user.service.UserService;

public class GuestLoginFilter extends AbstractAuthenticationProcessingFilter {

    private final JWTUtil jwtUtil;
    private final UserService userService;

    private static final long EXPIRATION_TIME = 10 * 60 * 60 * 1000L; // 10시간 (refresh token 적용시 변경 예정)

    public GuestLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserService userService) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        // JSON 데이터를 Map으로 읽음
        Map<String, String> authRequestMap = mapper.readValue(request.getInputStream(), Map.class);
        String name = authRequestMap.get("name");
        String email = authRequestMap.get("email");
        String code = authRequestMap.get("code");

        if (name == null) {
            name = "";
        }
        if (email == null) {
            email = "";
        }
        name = name.trim();
        email = email.trim();

        userService.autoRegisterAndLogin(name, email, code);

        GuestAuthenticationToken authRequest = new GuestAuthenticationToken(name, email);
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) throws IOException, ServletException {
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        String name = customUserDetails.getUsername();
        String email = customUserDetails.getEmail();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority().replace("ROLE_", "");
        String token = jwtUtil.createJwt(name, email, role, EXPIRATION_TIME);

        response.addHeader("Authorization", "Bearer " + token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(401);
    }
}
