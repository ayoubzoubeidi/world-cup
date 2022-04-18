package tn.isi.worldcup.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.isi.worldcup.entities.Authority;
import tn.isi.worldcup.entities.User;
import tn.isi.worldcup.repository.UserRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            throw new UsernameNotFoundException("Email " + email + "Not Found");
        });

        return convertUserToSpringSecurityUser(user);
    }

    private UserDetails convertUserToSpringSecurityUser(User user) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(),
                convertUserAuthoritiesToSpringUserAuthority(user.getAuthorities()));
    }

    private Collection<? extends GrantedAuthority> convertUserAuthoritiesToSpringUserAuthority(Set<Authority> authorities) {
        if (authorities != null && !authorities.isEmpty()) {
            return authorities
                    .stream()
                    .map(Authority::getPermission)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
        } else
            return new HashSet<>();
    }

}
