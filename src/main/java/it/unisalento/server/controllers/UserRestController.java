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
    private IUserService userService;

    @GetMapping(value = "/getAll")
    public List<UserDTO> getAll(){
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getAll();
        Iterator<User> iter = userList.iterator();
        while (iter.hasNext())
            userDTOList.add(UserDTO.cvtUserDTO(iter.next()));
        return userDTOList;
    }

    @GetMapping(value = "/getByEmail/{email}")
    public User getByEmail(@PathVariable String email) throws UserNotFoundException {
        return userService.getByEmail(email);
    }

    @GetMapping(value = "/getAllByRole/{role}")
    public List<UserDTO> getAllByRole(@PathVariable String role) {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userService.getAllByRole(role);
        Iterator<User> iter = userList.iterator();
        while (iter.hasNext())
            userDTOList.add(UserDTO.cvtUserDTO(iter.next()));
        return userDTOList;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO save(@RequestBody UserDTO userDTO) throws UserAlreadyExistException {
       User userSaved = User.cvtUser(userDTO);
       return UserDTO.cvtUserDTO(userService.save(userSaved));
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO delete(@PathVariable int id) throws UserNotFoundException {
       return UserDTO.cvtUserDTO(userService.delete(id));
    }

    @GetMapping(value = "/getById/{id}")
    public UserDTO getById(@PathVariable int id) throws UserNotFoundException {
       User userSaved = userService.getById(id);
       return UserDTO.cvtUserDTO(userSaved);
    }

}
