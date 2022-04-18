package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.Staff;
import tn.isi.worldcup.dto.StaffDto;

@Mapper(uses = {TeamMapper.class})
public interface StaffMapper {

    StaffDto staffToStaffDto(Staff staff);
    Staff staffDtoToStaff(StaffDto staffDto);

}
