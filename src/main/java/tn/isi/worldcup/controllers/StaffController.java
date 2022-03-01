package tn.isi.worldcup.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.isi.worldcup.entities.Staff;
import tn.isi.worldcup.services.StaffService;

import java.util.List;

@RestController("/staffs")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @PostMapping
    public void createStaff(@RequestBody Staff staff) {
        staffService.createStaff(staff);
    }

    @PutMapping
    public void updateStaff(@RequestBody Staff staff) {
        staffService.createStaff(staff);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
    }

    @GetMapping("/{id}")
    public Staff getStaffById(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }
}