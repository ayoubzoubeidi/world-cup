package tn.isi.worldcup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.isi.worldcup.dto.RoleDto;
import tn.isi.worldcup.entities.Authority;
import tn.isi.worldcup.entities.Role;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface RoleMapper {

    @Mapping(target = "authorities", expression = "java( mapAuthorities(role.getAuthorities()) )")
    RoleDto roleToRoleDto(Role role);


    default List<String> mapAuthorities(Set<Authority> authorities) {
        return authorities
                .stream()
                .map(Authority::getPermission)
                .collect(Collectors.toList());
    }
}
