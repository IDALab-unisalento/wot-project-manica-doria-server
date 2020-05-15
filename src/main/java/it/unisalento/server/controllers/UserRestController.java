package it.unisalento.server.controllers;

import it.unisalento.server.entities.User;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    IUserService userService;
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }
}
