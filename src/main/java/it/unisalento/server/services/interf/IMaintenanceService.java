package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {

    List<Maintenance> getAll();
    Maintenance save(Maintenance maintenance);

}
