package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.Player;
import tn.isi.worldcup.repositories.PlayerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public void createPlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
