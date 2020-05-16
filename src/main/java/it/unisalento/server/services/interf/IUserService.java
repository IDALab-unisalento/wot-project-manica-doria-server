package it.unisalento.server.services.interf;

import it.unisalento.server.entities.User;
import it.unisalento.server.exception.UserNotFoundExecption;

import java.util.List;

public interface IUserService {

    List<User> getAll();
    User getUserByEmail(String email);

}
