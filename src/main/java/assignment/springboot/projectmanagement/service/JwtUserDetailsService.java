package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static assignment.springboot.projectmanagement.service.UsersService.createUserDetails;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUserName(username).get();
        if (user.getUserName().equals(username)) {
            return createUserDetails(user.getUserName(), user.getPassword());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}