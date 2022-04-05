package tn.isi.worldcup.mappers;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.Staff;
import tn.isi.worldcup.model.StaffDto;

@Mapper
public interface StaffMapper {

    StaffDto staffToStaffDto(Staff staff);
    Staff staffDtoToStaff(StaffDto staffDto);

}
