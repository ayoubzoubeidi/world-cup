package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.mappers.StaffMapper;
import tn.isi.worldcup.model.StaffDto;
import tn.isi.worldcup.repositories.StaffRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public void createStaff(StaffDto staffDto) {
        staffRepository.save(staffMapper.staffDtoToStaff(staffDto));
    }

    @Override
    public void updateStaff(StaffDto staffDto) {
        staffRepository.save(staffMapper.staffDtoToStaff(staffDto));
    }

    @Override
    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    public StaffDto getStaffById(Long id) {
        return staffMapper.staffToStaffDto(staffRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<StaffDto> getAllStaffs() {
        return staffRepository.findAll()
                .stream()
                .map(staffMapper::staffToStaffDto)
                .collect(Collectors.toList());
    }
}
