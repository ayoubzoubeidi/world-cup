package tn.isi.worldcup.dto;

import lombok.*;
import tn.isi.worldcup.entities.Staff;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class TeamDto {

    private Long id;
    private String name;
    private String address;
    private List<PlayerDto> players;
    private List<Staff> staffs;


}
