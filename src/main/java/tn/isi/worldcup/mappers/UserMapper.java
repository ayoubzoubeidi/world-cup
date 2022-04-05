package tn.isi.worldcup.mappers;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.User;
import tn.isi.worldcup.model.UserDto;

@Mapper
public interface UserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
