package com.jsprest.controller;

import com.jsprest.entity.Project;
import com.jsprest.entity.Task;
import com.jsprest.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {


    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(value = "/saveProject", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getSaved(Project project) {
        Map<String, Object> map = new HashMap<String, Object>();

        projectRepository.save(project);
        map.put("status", "200");
        map.put("message", "Project has been saved successfully");

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/viewProject", method = RequestMethod.GET)
    public String viewProject() {

        return "project/viewProject";
    }


    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject() {

        return "project/addProject";
    }


    @RequestMapping(value = "/allProject", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll(Task task) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Project> allProject = projectRepository.findAll();

        if (allProject != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", allProject);
        } else {
            map.put("status", "404");
            map.put("message", "Project not found");

        }

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(Project project) {
        Map<String, Object> map = new HashMap<String, Object>();

        projectRepository.delete(project);
        map.put("status", "200");
        map.put("message", "Your project has been deleted successfully");

        System.out.println(map);
        return map;
    }


}
