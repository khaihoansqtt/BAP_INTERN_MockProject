package com.base.mapper.mapstruct;

import com.base.dto.UserDTO;
import com.base.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO, User> {
    /**
     * convert User to UserDTO
     * @param user
     * @return
     */
    @Override
    @Mappings({
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "roles", ignore = true)
    })
    UserDTO toDTO(User user);

    /**
     * convert Users to UserDTOs
     * @param users
     * @return
     */
    @Override
    List<UserDTO> toListDTO(List<User> users);

    /**
     * convert UserDTO to User
     * @param userDTO
     * @return
     */
    @Override
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "roles", ignore = true)
    })
    User toEntity(UserDTO userDTO);

    /**
     * convert UserDTOs to Users
     * @param userDTOs
     * @return
     */
    @Override
    List<User> toListEntity(List<UserDTO> userDTOs);
}

