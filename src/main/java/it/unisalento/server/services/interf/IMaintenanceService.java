package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IMaintenanceService {

    Maintenance save(Maintenance maintenance);
    Maintenance delete(int id) throws UserNotFoundException;

    List<Maintenance> getAll();
    Maintenance getById(int id) throws UserNotFoundException;

}
