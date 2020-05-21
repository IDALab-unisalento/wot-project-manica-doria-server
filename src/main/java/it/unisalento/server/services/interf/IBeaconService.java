package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IBeaconService {

    Beacon save(Beacon beacon) throws UserAlreadyExistException;
    Beacon delete(int id) throws UserNotFoundException;

    List<Beacon> getAll();
    Beacon getById(int id) throws UserNotFoundException;

}
