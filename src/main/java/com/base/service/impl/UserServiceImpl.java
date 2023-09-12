package com.base.service.impl;

import com.base.dto.UserDTO;
import com.base.entity.Role;
import com.base.entity.User;
import com.base.entity.UserPrincipal;
import com.base.mapper.mapstruct.UserMapper;
import com.base.repository.RoleRepository;
import com.base.repository.UserRepository;
import com.base.repository.custom.sandbox.UserCustomRepository;
import com.base.request.UserRequest;
import com.base.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserCustomRepository userCustomRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(() ->
                new UsernameNotFoundException("User not found with id: " + id));

        return UserPrincipal.create(user);
    }

    @Override
    public UserDTO getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmailAndIsDeletedIsFalse(email);
        if(user.isPresent()){
            UserDTO result = userMapper.toDTO(user.get());
            result.setRoles(user.get().getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));
            return result;
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
        user.setIsDeleted(true);
        userRepository.saveAndFlush(user);
        log.info("Delete User with user id: " + id);
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        User user = userRepository.getOne(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setNumLoginAttempts(userDto.getNumLoginAttempts());

        List<Role> roles = roleRepository.findByIsDeletedIsFalseAndNameIn(userDto.getRoles());
        user.setRoles(roles);

        //update
        User userResult = userRepository.saveAndFlush(user);

        UserDTO result = userMapper.toDTO(userResult);
        result.setRoles(userResult.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));

        return result;
    }

    @Override
    public UserDTO createNewUser(UserDTO userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        List<Role> roles = roleRepository.findByIsDeletedIsFalseAndNameIn(userDto.getRoles());
        user.setRoles(roles);

        //save
        User userResult = userRepository.saveAndFlush(user);

        UserDTO result = userMapper.toDTO(userResult);
        result.setRoles(userResult.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));

        return result;
    }

    @Override
    public List<UserDTO> getListUsers(UserRequest userRequest) {
        List<User> users = userCustomRepository.getListUsers(userRequest);
        List<UserDTO> result = users.stream().map(user -> {
            UserDTO userDTO = userMapper.toDTO(user);
            if(null != user.getRoles() && user.getRoles().size() > 0){
                userDTO.setRoles(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));
            }
            return userDTO;
        }).collect(Collectors.toList());
        return result;
    }
}
