package tn.isi.worldcup.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.isi.worldcup.mappers.TeamMapper;
import tn.isi.worldcup.model.TeamDto;
import tn.isi.worldcup.repositories.TeamRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public void createTeam(TeamDto teamDto) {

    }

    @Override
    public void updateTeam(TeamDto teamDto) {
        teamRepository.save(teamMapper.teamDtoToTeam(teamDto));
    }

    @Override
    public void deleteTeamById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public TeamDto getTeamById(Long id) {
        return teamMapper.teamToTeamDto(teamRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::teamToTeamDto)
                .collect(Collectors.toList());
    }
    
}
