package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.repositories.MachineRepository;
import it.unisalento.server.services.interf.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService implements IMachineService {

    @Autowired
    MachineRepository machineRepository;

    @Override
    public List<Machine> getAll() {
        return machineRepository.findAll();
    }

    @Override
    public Machine save(Machine machine) {
        return machineRepository.save(machine);
    }
}
