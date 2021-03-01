package com.jsprest.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsprest.entity.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AdminPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final Long id;

    private final String name;


    private final String email;

    @JsonIgnore
    private final String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public AdminPrinciple(Long id, String name,
                          String email, String password,
                          Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;

        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static AdminPrinciple build(Admin admin) {
        List<GrantedAuthority> authorities = admin.getRole().stream().map(role ->
                new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());

        return new AdminPrinciple(
                admin.getId(),
                admin.getName(),

                admin.getEmail(),
                admin.getPassword(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminPrinciple admin = (AdminPrinciple) o;
        return Objects.equals(id, admin.id);
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }
}