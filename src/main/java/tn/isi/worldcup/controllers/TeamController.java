package tn.isi.worldcup.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.isi.worldcup.entities.Team;
import tn.isi.worldcup.services.TeamService;

import java.util.List;

@RestController("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public void createTeam(@RequestBody Team team) {
        teamService.createTeam(team);
    }

    @PutMapping
    public void updateTeam(@RequestBody Team team) {
        teamService.createTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeamById(@PathVariable Long id) {
        teamService.deleteTeamById(id);
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }
}
