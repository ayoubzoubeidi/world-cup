package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.Player;
import tn.isi.worldcup.dto.PlayerDto;

@Mapper
public interface PlayerMapper {

    PlayerDto playerToPlayerDto(Player player);

    Player playerDtoToPlayer(PlayerDto playerDto);

}
