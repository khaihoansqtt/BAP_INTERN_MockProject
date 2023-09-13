//package com.base.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Getter
//public class UserPrincipal implements UserDetails {
//
//    private Long id;
//
//    private String userName;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String email;
//
//    @JsonIgnore
//    private String password;
//
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(Long id, String userName, String firstName, String lastName,
//                         String email, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.id = id;
//        this.userName = userName;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//    /**
//     * create UserPrincipal by User
//     * @param user
//     * @return
//     */
//    public static UserPrincipal create(User user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().
//                map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).
//                collect(Collectors.toList());
//
//        return new UserPrincipal(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(),
//                user.getEmail(), user.getPassword(), authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}