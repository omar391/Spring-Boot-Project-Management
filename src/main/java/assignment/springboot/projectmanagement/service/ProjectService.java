package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Users;
import assignment.springboot.projectmanagement.repository.ProjectRepository;
import assignment.springboot.projectmanagement.entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Projects> listProjects(int curPageIdx, int countPerPage) {
        return projectRepository.listProjects(PageRequest.of(curPageIdx, countPerPage));
    }

    @Override
    public void createProject(String name, String desc, long owner) {
        projectRepository.save(new Projects(name, desc, owner));
    }
}