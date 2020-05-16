package it.unisalento.server.controllers;

import it.unisalento.server.entities.User;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping(value = "/getByEmail/{email}", method = RequestMethod.GET)
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/getAllByRole/{role}", method = RequestMethod.GET)
    public List<User> getAllByRole(@PathVariable String role) {
        return userService.getAllByRole(role);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Optional<User> getById(@PathVariable int id) {
        return userService.getById(id);
    }


}
