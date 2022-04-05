package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.User;
import tn.isi.worldcup.dto.UserDto;

@Mapper
public interface UserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
