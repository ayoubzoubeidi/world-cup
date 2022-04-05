package tn.isi.worldcup.model;

import tn.isi.worldcup.entities.Staff;

import java.util.List;

public record TeamDto(Long id, String name, String address, List<PlayerDto> players, List<Staff> staffs) {
}
