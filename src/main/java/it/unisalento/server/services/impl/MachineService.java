package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.MachineRepository;
import it.unisalento.server.services.interf.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MachineService implements IMachineService {

    @Autowired
    MachineRepository machineRepository;

    @Override
    @Transactional
    public Machine save(Machine machine) throws ObjectAlreadyExistException {
        if(machineRepository.findBySerialNumber(machine.getSerialNumber()).isPresent())
            throw new ObjectAlreadyExistException("Machine Already Exist");
        else
            return machineRepository.save(machine);
    }

    @Override
    @Transactional
    public Machine delete(int id) throws ObjectNotFoundException {
        Optional<Machine> machine = machineRepository.findById(id);
        if(machine.isPresent()) {
            machineRepository.delete(machine.get());
            return machine.get();
        }
        else
            throw new ObjectNotFoundException("Beacon does not found");
    }

    @Override
    @Transactional
    public List<Machine> getAll() {
        return machineRepository.findAll();
    }

    @Override
    @Transactional
    public Machine getById(int id) throws ObjectNotFoundException {
        return machineRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Machine with id='"+id+"' Not Found"));
    }
}
