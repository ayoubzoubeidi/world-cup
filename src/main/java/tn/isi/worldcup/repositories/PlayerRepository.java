package tn.isi.worldcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.isi.worldcup.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
