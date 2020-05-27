package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.entities.Machine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MachineMapper {

    public static MachineDTO makeMachineDTO(Machine machine){
        MachineDTO.MachineDTOBuilder machineDTOBuilder = new MachineDTO.MachineDTOBuilder()
                .setId(machine.getId())
                .setName(machine.getName())
                .setSerialNumber(machine.getSerialNumber());

        return machineDTOBuilder.build();
    }

    public static Machine makeMachine(MachineDTO machineDTO){
        return new Machine(
                machineDTO.getId(),
                machineDTO.getName(),
                machineDTO.getSerialNumber());
    }

    public static List<MachineDTO> makeMachineDTOList(List<Machine> machineList) {
        Iterator<Machine> iter = machineList.iterator();
        List<MachineDTO> machineDTOList = new ArrayList<>();
        while (iter.hasNext()) machineDTOList.add(makeMachineDTO(iter.next()));
        return machineDTOList;
    }

    public static List<Machine> makeMachineList(List<MachineDTO> machineDTOList) {
        Iterator<MachineDTO> iter = machineDTOList.iterator();
        List<Machine> machineList = new ArrayList<>();
        while (iter.hasNext()) machineList.add(makeMachine(iter.next()));
        return machineList;
    }
}
