package it.unisalento.server.controllers;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.controllers.mapper.UserMapper;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO save(@RequestBody UserDTO userDTO) throws UserAlreadyExistException {
        return UserMapper.makeUserDTO(userService.save(UserMapper.makeUser(userDTO)));
    }

    @DeleteMapping(value = "/delete/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO delete(@PathVariable int id) throws UserNotFoundException {
        return UserMapper.makeUserDTO(userService.delete(id));
    }

    @GetMapping(value = "/getById/{id}")
    public UserDTO getById(@PathVariable int id) throws UserNotFoundException {
        return UserMapper.makeUserDTO(userService.getById(id));
    }

    @GetMapping(value = "/getAll")
    public List<UserDTO> getAll(){
        return UserMapper.makeUserDTOList(userService.getAll());
    }

    @GetMapping(value = "/getByEmail/{email}")
    public UserDTO getByEmail(@PathVariable String email) throws UserNotFoundException {
        return UserMapper.makeUserDTO(userService.getByEmail(email));
    }

    @GetMapping(value = "/getAllByRole/{role}")
    public List<UserDTO> getAllByRole(@PathVariable String role) {
        return UserMapper.makeUserDTOList(userService.getAllByRole(role));
    }


}
