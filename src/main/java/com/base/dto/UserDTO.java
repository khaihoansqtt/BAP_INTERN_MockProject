package com.base.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO{
    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private int numLoginAttempts;

    private List<String> roles;
}
