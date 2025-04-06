package zoo.insightnote.global.oauth2.dto;

import lombok.Builder;
import lombok.Getter;
import zoo.insightnote.domain.user.entity.Role;

@Getter
@Builder
public class UserDto {

    private String name;
    private String username;
    private Role role;
    private String email;
}
