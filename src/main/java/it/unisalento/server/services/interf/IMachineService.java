package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IMachineService {

    Machine save(Machine machine) throws ObjectAlreadyExistException;
    Machine delete(int id) throws ObjectNotFoundException;

    List<Machine> getAll();
    Machine getById(int id) throws ObjectNotFoundException;

}
