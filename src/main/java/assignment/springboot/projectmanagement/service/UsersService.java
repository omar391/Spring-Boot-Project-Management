package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.repository.UserRepository;
import assignment.springboot.projectmanagement.utils.DbSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsersService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    void init(){
        DbSeeder.seedDB(userRepository);
    }

    @Override
    public void createUser(String name, String userName, String password) {
        userRepository.save(new Users(name, userName, password));
    }

    @Override
    public Optional<Users> getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public static User createUserDetails(String name, String pass){
        return new User(name, pass, new ArrayList<>());
    }
}
