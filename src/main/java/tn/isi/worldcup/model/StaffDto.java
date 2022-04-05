package tn.isi.worldcup.model;

import java.util.Date;

public record StaffDto(Long id, String firstName, String lastName, String job, Date date, TeamDto teamDto) {
}
