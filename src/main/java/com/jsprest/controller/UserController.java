package com.jsprest.controller;

import com.jsprest.entity.Users;
import com.jsprest.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {


    @Autowired
    UsersService userServices;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView view = new ModelAndView("home");
        return view;
    }


    @RequestMapping(value = "/viewUser", method = RequestMethod.GET)
    public String getPage11() {

        return "user/home";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {

        return "user/add";
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.GET)
    public String getAllUsers(Users users) {


        List<Users> list = userServices.list();


        return list.toString();
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getSaved(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();

        userServices.saveOrUpdate(users);
        map.put("status", "200");
        map.put("message", "Your record have been saved successfully");

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAll(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Users> list = userServices.list();

        if (list != null) {
            map.put("status", "200");
            map.put("message", "Data found");
            map.put("data", list);
        } else {
            map.put("status", "404");
            map.put("message", "Data not found");

        }

        System.out.println(map);
        return map;
    }


    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> delete(Users users) {
        Map<String, Object> map = new HashMap<String, Object>();

        userServices.delete(users);
        map.put("status", "200");
        map.put("message", "Your record have been deleted successfully");

        System.out.println(map);
        return map;
    }
}
