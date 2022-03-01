package tn.isi.worldcup.services;

import tn.isi.worldcup.entities.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
    
}
