package tn.isi.worldcup.model;

import lombok.Builder;

import java.util.Date;

public record PlayerDto(Long id, String firstName, String lastName,
                        String position, Date date, TeamDto teamDto) {
}
