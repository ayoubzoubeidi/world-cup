package tn.isi.worldcup.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tn.isi.worldcup.entities.Authority;
import tn.isi.worldcup.entities.Role;
import tn.isi.worldcup.entities.ApplicationUser;
import tn.isi.worldcup.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows
    public void run(String... args) throws Exception {
            userRepository.deleteAll();
            userRepository.saveAndFlush(ApplicationUser.builder()
                    .username("ayoub")
                    .password(passwordEncoder.encode("ayoub"))
                    .role(Role.builder().name("admin").authority(Authority.builder().permission("read.all").build()).build())
                    .build());

    }
}
