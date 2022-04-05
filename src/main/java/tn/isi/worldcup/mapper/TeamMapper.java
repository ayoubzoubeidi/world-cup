package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.Team;
import tn.isi.worldcup.dto.TeamDto;

@Mapper(uses = {PlayerMapper.class, StaffMapper.class})
public interface TeamMapper {

    TeamDto teamToTeamDto(Team team);

    Team teamDtoToTeam(TeamDto teamDto);

}
