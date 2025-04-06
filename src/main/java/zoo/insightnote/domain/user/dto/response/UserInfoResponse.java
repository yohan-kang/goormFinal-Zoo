package zoo.insightnote.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {
    private String name;
    private String nickname;
    private String email;
    private String phoneNumber;
    private String occupation;
    private String job;
    private String interestCategory;
    private String snsUrl;
    private String username;
}
