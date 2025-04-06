package zoo.insightnote.domain.user.service;

import static zoo.insightnote.domain.user.entity.Role.*;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoo.insightnote.global.oauth2.dto.CustomOAuth2User;
import zoo.insightnote.global.oauth2.dto.GoogleResponse;
import zoo.insightnote.global.oauth2.dto.KakaoResponse;
import zoo.insightnote.global.oauth2.dto.OAuth2Response;
import zoo.insightnote.global.oauth2.dto.UserDto;
import zoo.insightnote.domain.user.entity.User;
import zoo.insightnote.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = getOAuth2User(registrationId, oAuth2User);

        String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
        String email = oAuth2Response.getEmail();
        User existData = userRepository.findByUsername(email)
                .orElseGet(() -> userRepository.findByUsername(username).orElse(null));
        return saveOAuth2User(existData, username, oAuth2Response);
    }

    private CustomOAuth2User saveOAuth2User(User existData, String username, OAuth2Response oAuth2Response) {
        if(existData == null){
            User user = User.builder()
                    .username(username)
                    .name(oAuth2Response.getName())
                    .email(oAuth2Response.getEmail())
                    .role(USER)
                    .build();
            userRepository.save(user);

            UserDto userDto = UserDto.builder()
                    .username(username)
                    .name(user.getName())
                    .email(user.getEmail())
                    .role(USER)
                    .build();
            return new CustomOAuth2User(userDto);
        }

        // existData.update(oAuth2Response.getEmail(), oAuth2Response.getName());
        existData.updateUsername(username);

        UserDto userDto = UserDto.builder()
                .username(username)
                .name(existData.getName())
                .email(existData.getEmail())
                .role(USER)
                .build();
        return new CustomOAuth2User(userDto);
    }

    private static OAuth2Response getOAuth2User(String registrationId, OAuth2User oAuth2User) {
        if (registrationId.equals("kakao")){
            return new KakaoResponse(oAuth2User.getAttributes());
        }
        if (registrationId.equals("google")){
            return new GoogleResponse(oAuth2User.getAttributes());
        }
        return null;
    }
}
