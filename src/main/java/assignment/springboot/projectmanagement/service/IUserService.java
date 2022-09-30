package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Users;

import java.util.Optional;

public interface IUserService {

    void createUser(String name, String userName, String password);

    Optional<Users> getUser(String userName);
}