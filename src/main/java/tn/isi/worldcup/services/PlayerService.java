package tn.isi.worldcup.services;

import tn.isi.worldcup.model.PlayerDto;

import java.util.List;

public interface PlayerService {

    void createPlayer(PlayerDto playerDto);

    void updatePlayer(PlayerDto playerDto);

    void deletePlayerById(Long id);

    PlayerDto getPlayerById(Long id);

    List<PlayerDto> getAllPlayers();
}
