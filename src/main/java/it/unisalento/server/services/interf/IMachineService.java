package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Machine;

import java.util.List;

public interface IMachineService {

    List<Machine> findAll();
    Machine save(Machine machine);
}
