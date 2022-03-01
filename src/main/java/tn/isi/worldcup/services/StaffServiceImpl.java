package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.Staff;
import tn.isi.worldcup.entities.Staff;
import tn.isi.worldcup.repositories.StaffRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Override
    public void createStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

    @Override
    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }
}
