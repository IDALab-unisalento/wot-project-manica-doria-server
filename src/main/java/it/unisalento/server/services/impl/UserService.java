package it.unisalento.server.services.impl;

import it.unisalento.server.entities.User;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.repositories.UserRepository;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public User getByEmail(String email) throws UserNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User with email='"+email+"' Not Found"));
    }

    @Override
    public User getById(int id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id='"+id+"' Not Found"));
    }

    @Override
    public User save(User user) throws UserAlreadyExistException {
        if (userRepository.findByEmailAndSerialNumber(user.getEmail(), user.getSerialNumber()).isPresent())
            throw new UserAlreadyExistException("User Already Exist");
        else
            return userRepository.save(user);
    }

    @Override
    @Transactional
    public User delete(int id) throws UserNotFoundException {
        Optional<User> deleted = userRepository.findById(id);
        if (deleted.isPresent()) {
            userRepository.delete(deleted.get());
            return deleted.get();
        } else throw new UserNotFoundException("User Not Found");
    }

}
