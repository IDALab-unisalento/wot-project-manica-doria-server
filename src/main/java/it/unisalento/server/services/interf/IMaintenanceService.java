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
    List<Maintenance> getAllByMachine(int id);
    List<Maintenance> getAllByStatus(String status);
    //List<Maintenance> getByStatusAndUser(String status, int id);
    //Maintenance startMaintenance(int id_maintenance, int id_user) throws ObjectNotFoundException;
    //Maintenance completeMaintenance(int id) throws ObjectNotFoundException;

}
