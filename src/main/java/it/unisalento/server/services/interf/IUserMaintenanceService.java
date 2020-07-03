package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.User;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IUserMaintenanceService {

    /* --------------------- CRUD --------------------- */
    UserMaintenance save(UserMaintenance userMaintenance) throws ObjectNotFoundException;
    UserMaintenance delete(int id) throws ObjectNotFoundException;

    /* -------------------- GETTER -------------------- */
    List<Maintenance> getUserMaintenanceById(int id);
    List<UserMaintenance> getAll();

    List<UserMaintenance> getAllByUserId(int id);
    List<UserMaintenance> getByStatusAndUser(String status, int id);
    List<UserMaintenance> getAllByStatus(String status);
    UserMaintenance startMaintenance(int id_maintenance, int id_user) throws ObjectNotFoundException;
    UserMaintenance completeMaintenance(int id) throws ObjectNotFoundException;


}
