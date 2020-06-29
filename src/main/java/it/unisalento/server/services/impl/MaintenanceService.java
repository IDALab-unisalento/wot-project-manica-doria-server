package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.User;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.MachineRepository;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.repositories.UserRepository;
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
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public Maintenance save(Maintenance maintenance) throws ObjectAlreadyExistException, ObjectNotFoundException  {
        Optional<Machine> machine = machineRepository.findById(maintenance.getMachine().getId());
        if (machine.isPresent()) {
            maintenance.setMachine(machine.get());
            return maintenanceRepository.save(maintenance);
        } else {
            throw new ObjectNotFoundException("Child Object not Found");
        }
    }

    @Override
    @Transactional
    public Maintenance delete(int id) throws ObjectNotFoundException {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(id);
        if(maintenance.isPresent()) {
            maintenanceRepository.delete(maintenance.get());
            return maintenance.get();
        }
        else
            throw new ObjectNotFoundException("Maintenance does not found");
    }

    @Override
    @Transactional
    public List<Maintenance> getAll() {
        return maintenanceRepository.findAll();
    }

    @Override
    @Transactional
    public Maintenance getById(int id) throws ObjectNotFoundException {
        return maintenanceRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("No Maintenance Started"));
    }

    @Override
    public List<Maintenance> getAllByMachine(int id) {
        return maintenanceRepository.findMaintenanceByMachine_Id(id);
    }

    @Override
    public List<Maintenance> getAllByStatus(String status) {
        return maintenanceRepository.findAllByStatus(status);
    }

    /*@Override
    public List<Maintenance> getByStatusAndUser(String status, int id){
        return maintenanceRepository.findMaintenanceByStatusAndUser_Id(status, id);
    }*/

    /*@Override
    public Maintenance startMaintenance(int id_maintenance, int id_user) throws ObjectNotFoundException {
        List<Maintenance> started = maintenanceRepository.findMaintenanceByStatusAndUser_Id("started", id_user);
        System.out.println(started);
        if ((started.isEmpty())) {
            Optional<Maintenance> maintenance = maintenanceRepository.findMaintenanceByIdAndUser_Id(id_maintenance, id_user);
            if (maintenance.isPresent()){
                maintenance.get().setStatus("started");
                return maintenanceRepository.save(maintenance.get());
            } else {
                throw new ObjectNotFoundException("Maintenance Not Found");
            }
        }
        else throw new ObjectNotFoundException("Maintenance Already Started");
    }*/

    /*@Override
    public Maintenance completeMaintenance(int id) throws ObjectNotFoundException {
        Optional<Maintenance> started = maintenanceRepository.findById(id);
        if (started.isPresent()) {
            started.get().setStatus("completed");
            return maintenanceRepository.save(started.get());
        }
        else throw new ObjectNotFoundException("Maintenance Not Found");
    }*/
}
