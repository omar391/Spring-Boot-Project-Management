package assignment.springboot.projectmanagement.utils;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.repository.UserRepository;

public class DbSeeder {
    public static void seedDB(UserRepository userRepository) {
        if (userRepository.count() == 0) {
            userRepository.save(new Users("Test-Project-Admin", "test-admin", "test-pass"));
        }
    }
}
