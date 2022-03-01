package tn.isi.worldcup.services;

import tn.isi.worldcup.entities.Staff;

import java.util.List;

public interface StaffService {

    void createStaff(Staff staff);

    void updateStaff(Staff staff);

    void deleteStaffById(Long id);

    Staff getStaffById(Long id);

    List<Staff> getAllStaffs();
}
