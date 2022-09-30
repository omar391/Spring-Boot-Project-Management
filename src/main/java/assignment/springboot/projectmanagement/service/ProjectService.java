package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.repository.ProjectRepository;
import assignment.springboot.projectmanagement.entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Projects> listProjects(int curPageIdx, int countPerPage) {
        return projectRepository.findAll(PageRequest.of(curPageIdx, countPerPage)).getContent();
    }

    @Override
    public void createProject(String name, String desc, String owner) {
        projectRepository.save(new Projects(name, desc, owner));
    }
}