package com.jsprest.service;

import com.jsprest.entity.Users;

import java.util.List;

public interface UsersService {
    Users saveOrUpdate(Users users);

    List<Users> list();

    void delete(Users users);
}