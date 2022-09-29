package assignment.springboot.projectmanagement.controller;

import assignment.springboot.projectmanagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create")
    public String showAddTodoPage(@RequestBody String name) {
        userService.createUser(name);
        return "{msg: 'User " + name + " is created successfully!'}";
    }
}
