package tn.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
