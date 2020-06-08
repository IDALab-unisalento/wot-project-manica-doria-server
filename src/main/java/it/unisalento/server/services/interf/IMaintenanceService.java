package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IMaintenanceService {

    Maintenance save(Maintenance maintenance) throws ObjectAlreadyExistException, ObjectNotFoundException ;
    Maintenance delete(int id) throws ObjectNotFoundException;

    List<Maintenance> getAll();
    Maintenance getById(int id) throws ObjectNotFoundException;
    Maintenance getByStatusAndUser(String status, int id) throws ObjectNotFoundException;
    Maintenance startMaintenance(int id) throws ObjectNotFoundException;
    Maintenance completeMaintenance(int id) throws ObjectNotFoundException;

}
