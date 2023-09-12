package com.base.repository.custom.sandbox;

import com.base.entity.User;
import com.base.request.UserRequest;

import java.util.List;

public interface UserCustomRepository {
    /**
     * get list user by criteria in UserRequest
     * @param userRequest
     * @return
     */
    List<User> getListUsers(UserRequest userRequest);
}
