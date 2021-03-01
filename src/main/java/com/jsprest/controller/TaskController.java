package com.jsprest.controller;

import com.jsprest.entity.Task;
import com.jsprest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class TaskController {


    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = "/saveTask", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getSaved(Task task) {
        Map<String, Object> map = new HashMap<String, Object>();

        taskRepository.save(task);
        map.put("status", "200");
        map.put("message", "Task has been saved successfully");

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/viewTask", method = RequestMethod.GET)
    public String getPage11() {

        return "task/viewTask";
    }


    @RequestMapping(value = "/addTask", method = RequestMethod.GET)
    public String addTask() {

        return "task/addTask";
    }


    @RequestMapping(value = "/allTask", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll(Task task) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Task> allTask = taskRepository.findAll();

        if (allTask != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", allTask);
        } else {
            map.put("status", "404");
            map.put("message", "Task not found");

        }

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(Task task) {
        Map<String, Object> map = new HashMap<String, Object>();

        taskRepository.delete(task);
        map.put("status", "200");
        map.put("message", "Your task has been deleted successfully");

        System.out.println(map);
        return map;
    }


}
