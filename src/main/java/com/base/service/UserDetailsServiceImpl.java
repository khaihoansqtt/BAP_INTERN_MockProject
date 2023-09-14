package com.base.service;

import com.base.entity.MemberPrincipal;
import com.base.entity.TTMember;
import com.base.repository.TTMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private TTMemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TTMember ttMember = memberRepository.findByMemberMailAddressAndIsDeleteIsFalse(username).orElseThrow(() -> new UsernameNotFoundException("Member Not Found with email: " + username));
        return MemberPrincipal.create(ttMember);
    }
}
