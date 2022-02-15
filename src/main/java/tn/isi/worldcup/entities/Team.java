package tn.isi.worldcup.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "team")
    private Set<Staff> staffs = new HashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new HashSet<>();

}
