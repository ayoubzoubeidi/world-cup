package tn.isi.worldcup.service;

import tn.isi.worldcup.dto.StaffDto;

import java.util.List;

public interface StaffService {

    void createStaff(StaffDto staffDto);

    void updateStaff(StaffDto staffDto);

    void deleteStaffById(Long id);

    StaffDto getStaffById(Long id);

    List<StaffDto> getAllStaffs();
}
