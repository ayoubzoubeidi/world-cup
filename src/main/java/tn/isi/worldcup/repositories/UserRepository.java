package tn.isi.worldcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
