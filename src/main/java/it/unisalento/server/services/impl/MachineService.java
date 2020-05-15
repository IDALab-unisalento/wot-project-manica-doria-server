package it.unisalento.server.services.impl;

import it.unisalento.server.repositories.MachineRepository;
import it.unisalento.server.services.interf.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService implements IMachineService {

    @Autowired
    MachineRepository machineRepository;
}
