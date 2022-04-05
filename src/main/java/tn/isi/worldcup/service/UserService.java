package tn.isi.worldcup.service;

import tn.isi.worldcup.dto.UserDto;

import java.util.List;

public interface UserService {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUserById(Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();
    
}
