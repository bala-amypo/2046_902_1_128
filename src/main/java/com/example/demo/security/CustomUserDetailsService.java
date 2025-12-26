package com.example.demo.security;

import com.example.demo.entity.InvestorProfile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetailsSercive implements UserDetails {

    private final InvestorProfile user;

    public CustomUserDetailsService(InvestorProfile user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // No roles for now
    }

    @Override
    public String getPassword() {
        return user.getPassword();   // Ensure field exists
    }

    @Override
    public String getUsername() {
        return user.getEmail();     // or getUsername()
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}
