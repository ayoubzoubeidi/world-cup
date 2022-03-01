package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.User;
import tn.isi.worldcup.entities.User;
import tn.isi.worldcup.repositories.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
