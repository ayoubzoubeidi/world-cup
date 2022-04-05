package tn.isi.worldcup.mappers;

import org.mapstruct.Mapper;
import tn.isi.worldcup.entities.Player;
import tn.isi.worldcup.model.PlayerDto;

@Mapper
public interface PlayerMapper {

    PlayerDto playerToPlayerDto(Player player);

    Player playerDtoToPlayer(PlayerDto playerDto);

}
