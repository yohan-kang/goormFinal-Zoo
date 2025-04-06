package zoo.insightnote.global.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import zoo.insightnote.domain.user.service.CustomUserDetailsService;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

//        String requestURI = request.getRequestURI();
//        if (isIgnoredUri(requestURI)) {
//            filterChain.doFilter(request, response);
//            return;
//        }

        String token = getTokenFromRequest(request);
        //checkAuthorization(request, response, filterChain, token);
        //checkToken(request, response, filterChain, token);

        if(token != null) {
            if(jwtUtil.isExpired(token)) {
                throw new AuthenticationException("token expired") {
                };
            }
            String username = jwtUtil.getUsername(token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            Authentication authToken = new UsernamePasswordAuthenticationToken(userDetails, null,
                    userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }

//    private boolean isIgnoredUri(String uri) {
//        return uri.startsWith("/swagger-ui")
//                || uri.startsWith("/v3/api-docs")
//                || uri.startsWith("/actuator")
//                || uri.startsWith("/favicon.ico")
//                || uri.startsWith("/login")
//                || uri.equals("/api/v1/sessions")
//                || uri.equals("/api/v1/sessions/{sessionId}")
//                || uri.equals("/api/v1/sessions/detailed")
//                || uri.startsWith("/api/v1/speakers")
//                || uri.startsWith("/api/v1/keywords")
//                || uri.startsWith("/api/v1/user/join")
//                || uri.startsWith("/api/v1/user/login");
//    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String headerToken = request.getHeader("Authorization");
        if (headerToken != null && headerToken.startsWith("Bearer ")) {
            return headerToken.substring(7); // "Bearer " 이후의 토큰 반환
        }

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                if (cookie.getName().equals("Authorization")) {
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

//    private void checkToken(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
//                            String token) throws IOException, ServletException {
//        if (jwtUtil.isExpired(token)) {
//            throw new AuthenticationException("token expired") {
//            };
//        }
//    }
//
//    private void checkAuthorization(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,
//                                    String authorization) throws IOException, ServletException {
//        if (authorization == null) {
//            throw new AuthenticationException("token null") {
//            };
//        }
//    }
}
