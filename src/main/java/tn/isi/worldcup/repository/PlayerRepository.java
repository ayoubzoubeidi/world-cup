package tn.isi.worldcup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
