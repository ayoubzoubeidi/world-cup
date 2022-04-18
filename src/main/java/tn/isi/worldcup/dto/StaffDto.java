package tn.isi.worldcup.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class StaffDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String job;
    private Date date;
    private TeamDto team;

}
