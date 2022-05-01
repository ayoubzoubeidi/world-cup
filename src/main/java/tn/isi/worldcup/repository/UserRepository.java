package tn.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.ApplicationUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);



}
