package tn.isi.worldcup.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.ApplicationUser;
import tn.isi.worldcup.mapper.UserMapper;
import tn.isi.worldcup.dto.UserDto;
import tn.isi.worldcup.repository.UserRepository;
import tn.isi.worldcup.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserDto userDto) {
        ApplicationUser user = userMapper.userDtoToUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        userRepository.save(userMapper.userDtoToUser(userDto));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.userToUserDto(userRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }
}
