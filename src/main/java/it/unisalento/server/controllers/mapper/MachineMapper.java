package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MachineMapper {

    public static MachineDTO makeMachineDTO(Machine machine){
        MachineDTO.MachineDTOBuilder machineDTOBuilder = new MachineDTO.MachineDTOBuilder()
                .setId(machine.getId())
                .setName(machine.getName());
        return machineDTOBuilder.build();
    }

    public static Machine makeMachine(MachineDTO machineDTO){
        return new Machine(machineDTO.getId(), machineDTO.getName());
    }

    public static List<MachineDTO> makeMachineDTO(List<Machine> userList) {
        Iterator<Machine> iter = userList.iterator();
        List<MachineDTO> machineDTOList = new ArrayList<>();
        while (iter.hasNext()) machineDTOList.add(makeMachineDTO(iter.next()));
        return machineDTOList;
    }

    public static List<Machine> makeMachine(List<MachineDTO> userList) {
        Iterator<MachineDTO> iter = userList.iterator();
        List<Machine> machineList = new ArrayList<>();
        while (iter.hasNext()) machineList.add(makeMachine(iter.next()));
        return machineList;
    }
}
