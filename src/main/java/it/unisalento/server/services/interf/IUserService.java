package it.unisalento.server.services.interf;

import it.unisalento.server.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> getAll();
    User getByEmail(String email);
    User save(User user);
    List<User> getAllByRole(String role);
    void delete(User user);
    Optional<User> getById(int id);

}
