package it.unisalento.server.controllers;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.controllers.mapper.UserMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO save(@RequestBody UserDTO userDTO) throws ObjectAlreadyExistException {
        return UserMapper.makeUserDTO(userService.save(UserMapper.makeUser(userDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public UserDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return UserMapper.makeUserDTO(userService.delete(id));
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO update(@RequestBody UserDTO userDTO) throws ObjectNotFoundException {
        return UserMapper.makeUserDTO(userService.update(UserMapper.makeUser(userDTO)));
    }

    @GetMapping(value = "/getById/{id}")
    public UserDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return UserMapper.makeUserDTO(userService.getById(id));
    }

    @GetMapping(value = "/getAll")
    public List<UserDTO> getAll(){
        return UserMapper.makeUserDTOList(userService.getAll());
    }

    @GetMapping(value = "/getByEmail/{email}")
    public UserDTO getByEmail(@PathVariable String email) throws ObjectNotFoundException {
        return UserMapper.makeUserDTO(userService.getByEmail(email));
    }

    @GetMapping(value = "/getAllByRole/{role}")
    public List<UserDTO> getAllByRole(@PathVariable String role) {
        return UserMapper.makeUserDTOList(userService.getAllByRole(role));
    }

    @GetMapping(value = "/login/{email}/{password}")
    public UserDTO getAllByRole(@PathVariable String email, @PathVariable String password) throws ObjectNotFoundException {
        return UserMapper.makeUserDTO(userService.login(email, password));
    }
}
