package it.unisalento.server.services.interf;

import it.unisalento.server.entities.User;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IUserService {

    /* --------------------- CRUD --------------------- */
    User save(User user) throws ObjectAlreadyExistException;
    User delete(int id) throws ObjectNotFoundException;

    /* -------------------- GETTER -------------------- */
    List<User> getAll();
    List<User> getAllByRole(String role);
    User getById(int id) throws ObjectNotFoundException;
    User getByEmail(String email) throws ObjectNotFoundException;

    User update(User makeUser) throws ObjectNotFoundException;
}
