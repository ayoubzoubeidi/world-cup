package tn.isi.worldcup.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String fistName;
    private String lastName;
    private String username;
    private String email;
    private String password;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private Set<Role> roles = new HashSet<>();

    @Transient
    private Set<Authority> authorities = new HashSet<>();

    public Set<Authority> getAuthorities() {
        return roles
                .stream()
                .map(Role::getAuthorities)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    @Builder.Default
    private boolean accountNonExpired = true;

    @Builder.Default
    private boolean accountNonLocked = true;

    @Builder.Default
    private boolean credentialsNonExpired = true;

    @Builder.Default
    private boolean enabled = true;

}
