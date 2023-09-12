package com.base.mapper.mapstruct;

import com.base.dto.RoleDTO;
import com.base.entity.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleDTO, Role> {
    /**
     * convert Role to RoleDTO
     * @param role
     * @return
     */
    @Override
    RoleDTO toDTO(Role role);

    /**
     * convert Roles to RoleDTOs
     * @param roles
     * @return
     */
    @Override
    List<RoleDTO> toListDTO(List<Role> roles);

    /**
     * convert RoleDTO to Role
     * @param roleDTO
     * @return
     */
    @Override
    Role toEntity(RoleDTO roleDTO);

    /**
     * convert RoleDTOs to Roles
     * @param roleDTOs
     * @return
     */
    @Override
    List<Role> toListEntity(List<RoleDTO> roleDTOs);
}
