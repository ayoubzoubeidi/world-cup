package tn.isi.worldcup.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
final public class RoleDto {

    private String name;

    private List<String> authorities = new ArrayList<>();

}
