package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IMachineService {

    Machine save(Machine machine) throws UserAlreadyExistException;
    Machine delete(int id) throws UserNotFoundException;

    List<Machine> getAll();
    Machine getById(int id) throws UserNotFoundException;

}
