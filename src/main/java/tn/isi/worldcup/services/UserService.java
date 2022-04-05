package tn.isi.worldcup.services;

import tn.isi.worldcup.model.UserDto;

import java.util.List;

public interface UserService {

    void createUser(UserDto userDto);

    void updateUser(UserDto userDto);

    void deleteUserById(Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();
    
}
