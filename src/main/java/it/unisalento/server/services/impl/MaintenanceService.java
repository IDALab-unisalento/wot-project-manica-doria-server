package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService implements IMaintenanceService {

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    @Transactional
    public Maintenance save(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    @Transactional
    public Maintenance delete(int id) throws UserNotFoundException {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);
        if(maintenance.isPresent()) {
            maintenanceRepository.delete(maintenance.get());
            return maintenance.get();
        }
        else
            throw new UserNotFoundException("Maintenance does not found");
    }

    @Override
    @Transactional
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    @Transactional
    public Maintenance getById(int id) throws UserNotFoundException {
        return maintenanceRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Machine with id='"+id+"' Not Found"));
    }
}
