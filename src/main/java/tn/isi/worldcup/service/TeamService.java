package tn.isi.worldcup.service;

import tn.isi.worldcup.dto.TeamDto;

import java.util.List;

public interface TeamService {

    void createTeam(TeamDto teamDto);

    void updateTeam(TeamDto teamDto);

    void deleteTeamById(Long id);

    TeamDto getTeamById(Long id);

    List<TeamDto> getAllTeams();
    
}
