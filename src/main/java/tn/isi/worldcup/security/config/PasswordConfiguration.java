package tn.isi.worldcup.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
public class PasswordConfiguration {
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }
}

