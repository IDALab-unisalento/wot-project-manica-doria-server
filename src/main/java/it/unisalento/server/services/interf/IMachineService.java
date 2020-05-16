package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Machine;

import java.util.List;

public interface IMachineService {

    List<Machine> getAll();
    Machine save(Machine machine);
}
