package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    @Transactional
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }


}
