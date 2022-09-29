package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(String nickName) {
        userRepository.save(new Users(nickName));
    }
}
