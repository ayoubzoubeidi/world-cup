package tn.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
