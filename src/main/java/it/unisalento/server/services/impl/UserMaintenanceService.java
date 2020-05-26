package it.unisalento.server.services.impl;

import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.UserMaintenanceRepository;
import it.unisalento.server.services.interf.IUserMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserMaintenanceService implements IUserMaintenanceService {

    @Autowired
    UserMaintenanceRepository userMaintenanceRepository;

    @Override
    public UserMaintenance save(UserMaintenance userMaintenance) throws ObjectAlreadyExistException {
        return userMaintenanceRepository.save(userMaintenance);
    }

    @Override
    public UserMaintenance delete(int id) throws ObjectNotFoundException {
        Optional<UserMaintenance> deleted = userMaintenanceRepository.findById(id);
        if (deleted.isPresent()) {
            userMaintenanceRepository.delete(deleted.get());
            return deleted.get();
        } else throw new ObjectNotFoundException("User Not Found");
    }

    @Override
    public List<UserMaintenance>getUserMaintenanceById(int id) {
        return userMaintenanceRepository.findUserMaintenanceByUser_Id(id);
    }

    @Override
    public List<UserMaintenance> getAll() {
        return userMaintenanceRepository.findAll();
    }
}
