package tn.isi.worldcup.services;

import tn.isi.worldcup.model.TeamDto;

import java.util.List;

public interface TeamService {

    void createTeam(TeamDto teamDto);

    void updateTeam(TeamDto teamDto);

    void deleteTeamById(Long id);

    TeamDto getTeamById(Long id);

    List<TeamDto> getAllTeams();
    
}
