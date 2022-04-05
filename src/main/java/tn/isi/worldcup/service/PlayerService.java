package tn.isi.worldcup.service;

import tn.isi.worldcup.dto.PlayerDto;

import java.util.List;

public interface PlayerService {

    void createPlayer(PlayerDto playerDto);

    void updatePlayer(PlayerDto playerDto);

    void deletePlayerById(Long id);

    PlayerDto getPlayerById(Long id);

    List<PlayerDto> getAllPlayers();
}
