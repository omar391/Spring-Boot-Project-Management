package assignment.springboot.projectmanagement.repository;

import assignment.springboot.projectmanagement.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String name);
}
