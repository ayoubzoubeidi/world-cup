package tn.isi.worldcup.services;

import tn.isi.worldcup.entities.Player;

import java.util.List;

public interface PlayerService {

    void createPlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayerById(Long id);

    Player getPlayerById(Long id);

    List<Player> getAllPlayers();
}
