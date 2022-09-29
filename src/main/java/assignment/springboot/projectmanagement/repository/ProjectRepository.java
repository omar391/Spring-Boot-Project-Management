package assignment.springboot.projectmanagement.repository;

import assignment.springboot.projectmanagement.entities.Projects;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Projects, Long> {
    List<Projects> listProjects(Pageable pageable);
}
