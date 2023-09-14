package com.base.service;

import com.base.dto.authentication.JwtDTO;
import com.base.dto.authentication.LoginRequest;
import com.base.entity.TTMember;
public interface AuthenticationService {
     JwtDTO authenticate(LoginRequest loginRequest);
     void saveTokenMember(TTMember ttMember, String jwtToken);
}
