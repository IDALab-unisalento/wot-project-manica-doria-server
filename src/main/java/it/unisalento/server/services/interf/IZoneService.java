package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IZoneService {
    Zone save(Zone zone) throws ObjectAlreadyExistException, ObjectNotFoundException;
    Zone delete(int id) throws ObjectNotFoundException;
    Zone getById(int id) throws ObjectNotFoundException;
    List<Zone> getAll();
}
