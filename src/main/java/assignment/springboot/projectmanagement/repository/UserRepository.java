package assignment.springboot.projectmanagement.repository;

import assignment.springboot.projectmanagement.entities.Projects;
import assignment.springboot.projectmanagement.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
}
