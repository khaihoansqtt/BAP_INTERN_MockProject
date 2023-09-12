package com.base.service;

import com.base.dto.UserDTO;
import com.base.request.UserRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    /**
     * load user by id
     * @param id
     * @return
     */
    UserDetails loadUserById(Long id);

    /**
     * get user by email
     * @param email
     * @return
     */
    UserDTO getUserByEmail(String email);

    /**
     * Delete user */
    void deleteUser(Long id);

    /**
     * Update user */
    UserDTO updateUser(UserDTO userDto);

    /**
     * Create new user */
    UserDTO createNewUser(UserDTO userDto);

    /**
     * Get list users */
    List<UserDTO> getListUsers(UserRequest userRequest);
}
