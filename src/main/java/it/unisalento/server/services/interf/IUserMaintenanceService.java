package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.User;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IUserMaintenanceService {

    /* --------------------- CRUD --------------------- */
    UserMaintenance save(UserMaintenance userMaintenance) throws ObjectAlreadyExistException;
    UserMaintenance delete(int id) throws ObjectNotFoundException;

    /* -------------------- GETTER -------------------- */
    List<Maintenance> getUserMaintenanceById(int id);
    List<UserMaintenance> getAll();


}
