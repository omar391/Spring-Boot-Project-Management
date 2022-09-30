package assignment.springboot.projectmanagement.repository;

import assignment.springboot.projectmanagement.entities.Projects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {
    Page<Projects> findAll(Pageable pageable);
}
