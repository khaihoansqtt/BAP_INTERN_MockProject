package com.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
@Getter
public class MemberPrincipal implements UserDetails {

    private Integer memberId;

    private String memberMailAddress;

    private String memberLastName;

    private String memberFirstName;

    @JsonIgnore
    private String password;

    public MemberPrincipal(Integer memberId, String memberMailAddress, String memberLastName, String memberFirstName, String password) {
        this.memberId = memberId;
        this.memberMailAddress = memberMailAddress;
        this.memberLastName = memberLastName;
        this.memberFirstName = memberFirstName;
        this.password = password;
    }

    /**
     * create UserPrincipal by User
     * @param ttMember
     * @return
     */
    public static MemberPrincipal create(TTMember ttMember) {
        return new MemberPrincipal(ttMember.getMemberId(), ttMember.getMemberMailAddress(), ttMember.getMemberLastName(), ttMember.getMemberFirstName(), ttMember.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return memberMailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
