package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IBeaconService {

    Beacon save(Beacon beacon) throws ObjectAlreadyExistException;
    Beacon delete(int id) throws ObjectNotFoundException;

    List<Beacon> getAll();
    Beacon getById(int id) throws ObjectNotFoundException;

}
