package com.base.service;

import com.base.entity.User;
import com.base.entity.UserPrincipal;
import com.base.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component("userDetailsService")
public class BaseUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameAndIsDeletedIsFalse(userName).orElseThrow(() ->
                new UsernameNotFoundException("User not found with user name: " + userName));

        return UserPrincipal.create(user);
    }
}
