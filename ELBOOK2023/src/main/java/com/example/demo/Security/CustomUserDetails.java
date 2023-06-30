package com.example.demo.Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Entity.UserList;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
	private int userId;

    public CustomUserDetails(UserList userList) {
        this.username = userList.getUser_name();
        this.password = userList.getPass();
        this.authorities = userList.getAuthority();
        this.userId = userList.getUser_id();
    }

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 以下のメソッドは必要に応じて実装する

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
