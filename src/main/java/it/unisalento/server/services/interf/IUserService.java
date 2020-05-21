package it.unisalento.server.services.interf;

import it.unisalento.server.entities.User;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IUserService {

    /* --------------------- CRUD --------------------- */
    User save(User user) throws UserAlreadyExistException;
    User delete(int id) throws UserNotFoundException;

    /* -------------------- GETTER -------------------- */
    List<User> getAll();
    List<User> getAllByRole(String role);
    User getById(int id) throws UserNotFoundException;
    User getByEmail(String email) throws UserNotFoundException;

    User update(User makeUser) throws UserNotFoundException;
}
