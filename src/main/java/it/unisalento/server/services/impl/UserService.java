package it.unisalento.server.services.impl;

import it.unisalento.server.entities.User;
import it.unisalento.server.repositories.UserRepository;
import it.unisalento.server.services.interf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
