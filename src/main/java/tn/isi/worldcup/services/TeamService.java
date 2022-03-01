package tn.isi.worldcup.services;

import tn.isi.worldcup.entities.Team;

import java.util.List;

public interface TeamService {

    void createTeam(Team team);

    void updateTeam(Team team);

    void deleteTeamById(Long id);

    Team getTeamById(Long id);

    List<Team> getAllTeams();
    
}
