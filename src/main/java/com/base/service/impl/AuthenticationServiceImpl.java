package com.base.service.impl;

import com.base.dto.authentication.JwtDTO;
import com.base.dto.authentication.LoginRequest;
import com.base.entity.MemberPrincipal;
import com.base.entity.TTMember;
import com.base.repository.TTMemberRepository;
import com.base.repository.TTTokenRepository;
import com.base.service.AuthenticationService;
import com.base.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private TTMemberRepository memberRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private TTTokenRepository tokenRepository;

    @Override
    public JwtDTO authenticate(LoginRequest loginRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        TTMember member = memberRepository.findByMemberMailAddressAndIsDeleteIsFalse(loginRequest.getEmail()).orElseThrow(null);

        MemberPrincipal memberPrincipal = MemberPrincipal.create(member);
        String jwtToken = jwtService.generateToken(memberPrincipal);

        JwtDTO jwtDTO = new JwtDTO(jwtToken, "bearer");
        return jwtDTO;
    }

    @Override
    public void saveTokenMember(TTMember ttMember, String jwtToken) {

    }
}
