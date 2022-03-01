package tn.isi.worldcup.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.isi.worldcup.entities.Player;
import tn.isi.worldcup.services.PlayerService;

import java.util.List;

@RestController("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    public void createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
    }

    @PutMapping
    public void updatePlayer(@RequestBody Player player) {
        playerService.createPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }
}