package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IZoneService {
    Zone save(Zone zone) throws UserAlreadyExistException;
    Zone delete(int id) throws UserNotFoundException;
    Zone getById(int id) throws UserNotFoundException;
    List<Zone> getAll();
}
