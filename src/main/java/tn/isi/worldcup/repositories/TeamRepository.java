package tn.isi.worldcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
