package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.UserMaintenanceRepository;
import it.unisalento.server.services.interf.IUserMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserMaintenanceService implements IUserMaintenanceService {

    @Autowired
    UserMaintenanceRepository userMaintenanceRepository;

    @Override
    @Transactional
    public UserMaintenance save(UserMaintenance userMaintenance) throws ObjectAlreadyExistException {
        return userMaintenanceRepository.save(userMaintenance);
    }

    @Override
    @Transactional
    public UserMaintenance delete(int id) throws ObjectNotFoundException {
        Optional<UserMaintenance> deleted = userMaintenanceRepository.findById(id);
        if (deleted.isPresent()) {
            userMaintenanceRepository.delete(deleted.get());
            return deleted.get();
        } else throw new ObjectNotFoundException("User Not Found");
    }

    @Override
    @Transactional
    public List<Maintenance> getUserMaintenanceById(int id) {
        List<UserMaintenance> userMaintenanceList = userMaintenanceRepository.findUserMaintenanceByUser_Id(id);
        List<Maintenance> maintenanceList = new ArrayList<>();
        Iterator<UserMaintenance> iter = userMaintenanceList.iterator();
        while (iter.hasNext()) {
            maintenanceList.add(iter.next().getMaintenance());
        }
        System.out.println(maintenanceList);
        return maintenanceList;
    }

    @Override
    @Transactional
    public List<UserMaintenance> getAll() {
        return userMaintenanceRepository.findAll();
    }
}
