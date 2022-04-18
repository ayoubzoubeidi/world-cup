package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.isi.worldcup.dto.UserDto;
import tn.isi.worldcup.entities.User;


@Mapper(uses = RoleMapper.class)
public interface UserMapper {

    @Mapping(target = "roles.authorities", ignore = true)
    UserDto userToUserDto(User user);
    @Mapping(target = "roles", ignore = true)
    User userDtoToUser(UserDto userDto);


}
