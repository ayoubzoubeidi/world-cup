package tn.isi.worldcup.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.mapper.PlayerMapper;
import tn.isi.worldcup.dto.PlayerDto;
import tn.isi.worldcup.repository.PlayerRepository;
import tn.isi.worldcup.service.PlayerService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    @Override
    public void createPlayer(PlayerDto playerDto) {
        playerRepository.save(playerMapper.playerDtoToPlayer(playerDto));
    }

    @Override
    public void updatePlayer(PlayerDto playerDto) {
        playerRepository.save(playerMapper.playerDtoToPlayer(playerDto));
    }

    @Override
    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public PlayerDto getPlayerById(Long id) {
        return playerMapper.playerToPlayerDto(playerRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<PlayerDto> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::playerToPlayerDto)
                .collect(Collectors.toList());
    }
}
