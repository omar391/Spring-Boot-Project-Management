package assignment.springboot.projectmanagement.controller;

import assignment.springboot.projectmanagement.entities.Projects;
import assignment.springboot.projectmanagement.model.Project;
import assignment.springboot.projectmanagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private IProjectService projService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/list")
    public Project.ListResponse showTodos(@RequestBody Project.ListRequest project) {
        List<Projects> data = projService.listProjects(project.pageNo, project.count);
        return new Project.ListResponse(Project.ListResponse.State.SUCCESS, "Get project list successful!", new Project.ListData(
                data.size(), data
        ));
    }

    @PostMapping("/create")
    public String showAddTodoPage(@RequestBody Project.CreateRequest req) {
        projService.createProject(req.name, req.desc, req.ownerId);
        return "{msg: 'Project is created successfully!'}";
    }
}
