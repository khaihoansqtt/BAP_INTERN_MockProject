package com.base.controller;

import com.base.dto.UserDTO;
import com.base.request.UserRequest;
import com.base.response.SuccessResponse;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
  @Autowired
  private UserService userService;

  @DeleteMapping("/delete-user/{id}")
  public Object deleteUser(@PathVariable("id") Long id) {
    userService.deleteUser(id);
    return new SuccessResponse<>();
  }

  @PutMapping("/update-user")
  public Object updateUser(@RequestBody UserDTO userDto) {
    UserDTO userDTO = userService.updateUser(userDto);
    return new SuccessResponse<>(userDTO);
  }

  @PostMapping("/create-user")
  public Object createNewUser(@RequestBody UserDTO userDto) {
    UserDTO userDTO = userService.createNewUser(userDto);
    return new SuccessResponse<>(userDTO);
  }

  @GetMapping("/get-users")
  public Object getListUsers(@Valid UserRequest userRequest) {
    return new SuccessResponse<>(userService.getListUsers(userRequest));
  }
}
