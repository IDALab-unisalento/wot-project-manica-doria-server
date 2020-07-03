package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.User;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.repositories.UserMaintenanceRepository;
import it.unisalento.server.repositories.UserRepository;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    @Transactional
    public UserMaintenance save(UserMaintenance userMaintenance) throws ObjectNotFoundException {
        Optional<User> user = userRepository.findById(userMaintenance.getUser().getId());
        Optional<Maintenance> maintenance = maintenanceRepository.findById(userMaintenance.getMaintenance().getId());
        if (user.isPresent() && maintenance.isPresent()) {
            maintenance.get().setStatus("forwarded");
            return userMaintenanceRepository.save(userMaintenance);
        } else {
            throw new ObjectNotFoundException("Child Object not Found");
        }
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

    @Override
    public List<UserMaintenance> getAllByUserId(int id) {
        return userMaintenanceRepository.findUserMaintenanceByUser_Id(id);
    }

    @Override
    public List<UserMaintenance> getByStatusAndUser(String status, int id) {
        return userMaintenanceRepository.findUserMaintenanceByStatusAndUser_Id(status, id);
    }

    @Override
    public List<UserMaintenance> getAllByStatus(String status) {
        return userMaintenanceRepository.findUserMaintenanceByStatus(status);
    }

    @Override
    public UserMaintenance startMaintenance(int id_maintenance, int id_user) throws ObjectNotFoundException {
        List<UserMaintenance> started = userMaintenanceRepository.findUserMaintenanceByStatusAndUser_Id("started", id_user);
        System.out.println(started);
        if ((started.isEmpty())) {
            Optional<UserMaintenance> userMaintenance = userMaintenanceRepository.findById(id_maintenance);
            if (userMaintenance.isPresent()){
                userMaintenance.get().setStatus("started");
                return userMaintenanceRepository.save(userMaintenance.get());
            } else {
                throw new ObjectNotFoundException("UserMaintenance Not Found");
            }
        }
        else throw new ObjectNotFoundException("UserMaintenance Already Started");
    }

    @Override
    public UserMaintenance completeMaintenance(int id) throws ObjectNotFoundException {
        Optional<UserMaintenance> started = userMaintenanceRepository.findById(id);
        if (started.isPresent()) {
            started.get().setStatus("completed");
            return userMaintenanceRepository.save(started.get());
        }
        else throw new ObjectNotFoundException("UserMaintenance Not Found");
    }
}
