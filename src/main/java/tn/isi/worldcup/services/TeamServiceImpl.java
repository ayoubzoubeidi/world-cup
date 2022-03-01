package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.entities.Team;
import tn.isi.worldcup.repositories.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
    
}
