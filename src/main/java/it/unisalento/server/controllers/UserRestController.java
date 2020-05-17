package it.unisalento.server.controllers;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.entities.User;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<UserDTO> getAll(){
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getAll();
        Iterator<User> iter = userList.iterator();
        while (iter.hasNext())
            userDTOList.add(UserDTO.cvtUserDTO(iter.next()));
        return userDTOList;
    }

    @RequestMapping(value = "/getByEmail/{email}", method = RequestMethod.GET)
    public User getByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.getByEmail(email);
    }

    @RequestMapping(value = "/getAllByRole/{role}", method = RequestMethod.GET)
    public List<UserDTO> getAllByRole(@PathVariable String role) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getAllByRole(role);
        Iterator<User> iter = userList.iterator();
        while (iter.hasNext())
            userDTOList.add(UserDTO.cvtUserDTO(iter.next()));
        return userDTOList;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> save(@RequestBody User user) throws UserAlreadyExistException {
        User userSaved = userService.save(user);
        UserDTO userDTO = UserDTO.cvtUserDTO(userSaved);
        return new ResponseEntity<>("User saved successfully\n"+userDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@RequestBody User user) throws UserNotFoundException {
        userService.delete(user);
        UserDTO userDTO = UserDTO.cvtUserDTO(user);
        return new ResponseEntity<>("User deleted successfully\n"+userDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public UserDTO getById(@PathVariable int id) throws UserNotFoundException {
        User userSaved = userService.getById(id);
        return UserDTO.cvtUserDTO(userSaved);
    }

}
