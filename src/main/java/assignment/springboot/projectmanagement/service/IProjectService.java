package assignment.springboot.projectmanagement.service;

import assignment.springboot.projectmanagement.entities.Projects;
import assignment.springboot.projectmanagement.entities.Users;

import java.util.List;

public interface IProjectService {

    List<Projects> listProjects(int curPageIdx, int countPerPage);

    void createProject(String name, String desc, long ownerId);
}