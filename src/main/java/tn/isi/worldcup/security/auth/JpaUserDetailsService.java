package tn.isi.worldcup.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.isi.worldcup.entities.ApplicationUser;
import tn.isi.worldcup.entities.Authority;
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = userRepository.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username " + username + "Not Found");
        });

        return convertUserToSpringSecurityUser(applicationUser);
    }

    private UserDetails convertUserToSpringSecurityUser(ApplicationUser applicationUser) {
        return new org.springframework.security.core.userdetails.User(applicationUser.getUsername(), applicationUser.getPassword(),
                applicationUser.isEnabled(), applicationUser.isAccountNonExpired(), applicationUser.isCredentialsNonExpired(), applicationUser.isAccountNonLocked(),
                convertUserAuthoritiesToSpringUserAuthority(applicationUser.getAuthorities()));
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
