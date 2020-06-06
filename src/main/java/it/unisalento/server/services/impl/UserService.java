package it.unisalento.server.services.impl;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.entities.User;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.UserRepository;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) throws ObjectAlreadyExistException {
        if (userRepository.findByEmailAndSerialNumber(user.getEmail(), user.getSerialNumber()).isPresent())
            throw new ObjectAlreadyExistException("User Already Exist");
        else
            return userRepository.save(user);
    }

    @Override
    @Transactional
    public User delete(int id) throws ObjectNotFoundException {
        Optional<User> deleted = userRepository.findById(id);
        if (deleted.isPresent()) {
            userRepository.delete(deleted.get());
            return deleted.get();
        } else throw new ObjectNotFoundException("User Not Found");
    }

    @Override
    public User update(User user) throws ObjectNotFoundException {
        Optional<User> updated = userRepository.findById(user.getId());
        if (updated.isPresent()){
            if (user.getName() != null) updated.get().setName(user.getName());
            if (user.getSurname() != null) updated.get().setSurname(user.getSurname());
            if (user.getSerialNumber() != null) updated.get().setSerialNumber(user.getSerialNumber());
            if (user.getEmail() != null) updated.get().setEmail(user.getEmail());
            if (user.getPassword() != null) updated.get().setPassword(user.getPassword());
            if (user.getRole() != null) updated.get().setRole(user.getRole());
            return userRepository.save(updated.get());
        }
        else throw new ObjectNotFoundException("User Not Found");
    }

    @Override
    public User login(String email, String password) throws ObjectNotFoundException {
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent())
            return userRepository.save(user.get());
        else
            throw new ObjectNotFoundException("User Not Exist");
    }

    @Override
    public User login(UserDTO userDTO) throws ObjectNotFoundException {
        Optional<User> user = userRepository.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());
        if (user.isPresent())
            return userRepository.save(user.get());
        else
            throw new ObjectNotFoundException("User Not Exist");
    }

    @Override
    public User getById(int id) throws ObjectNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User with id='"+id+"' Not Found"));
    }

    @Override
    @Transactional
    public List<User> getAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty())
            return new ArrayList<>();
        else
            return userList;
    }

    @Override
    public List<User> getAllByRole(String role) {
        List<User> userList = userRepository.findAllByRole(role);
        if (userList.isEmpty())
            return new ArrayList<>();
        else
            return userList;
    }

    @Override
    @Transactional
    public User getByEmail(String email) throws ObjectNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("User with email='"+email+"' Not Found"));
    }




}
