package tn.isi.worldcup.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class UserDto {
    private String fistName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<RoleDto> roles = new ArrayList<>();
}
