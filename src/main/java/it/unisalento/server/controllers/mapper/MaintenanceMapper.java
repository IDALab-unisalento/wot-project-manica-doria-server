package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaintenanceMapper {

     public static MaintenanceDTO makeMaintenanceDTO(Maintenance maintenance) {
         MaintenanceDTO.MaintenanceDTOBuilder maintenanceDTOBuilder = new MaintenanceDTO.MaintenanceDTOBuilder()
                 .setId(maintenance.getId())
                 .setName(maintenance.getName())
                 .setDescription(maintenance.getDescription())
                 .setType(maintenance.getType())
                 .setStatus(maintenance.getStatus());

         if (maintenance.getMachine() != null)
            maintenanceDTOBuilder.setMachine(MachineMapper.makeMachineDTO(maintenance.getMachine()));

         return maintenanceDTOBuilder.build();
     }

     public static Maintenance makeMaintenance(MaintenanceDTO maintenanceDTO) {
         Maintenance maintenance = new Maintenance(
                 maintenanceDTO.getId(),
                 maintenanceDTO.getName(),
                 maintenanceDTO.getDescription(),
                 maintenanceDTO.getType(),
                 maintenanceDTO.getStatus(),
                 new Machine());

         if (maintenanceDTO.getMachine() != null) {
             maintenance.setMachine(MachineMapper.makeMachine(maintenanceDTO.getMachine()));
         }

         return maintenance;

     }

     public static List<MaintenanceDTO> makeMaintenanceDTOList(List<Maintenance> maintenanceList) {
        Iterator<Maintenance> iter = maintenanceList.iterator();
        List<MaintenanceDTO> maintenanceDTOList = new ArrayList<>();
        while (iter.hasNext()) maintenanceDTOList.add(makeMaintenanceDTO(iter.next()));
        return maintenanceDTOList;
     }

     public static List<Maintenance> makeMaintenanceList(List<MaintenanceDTO> maintenanceDTOList) {
        Iterator<MaintenanceDTO> iter = maintenanceDTOList.iterator();
        List<Maintenance> maintenanceList = new ArrayList<>();
        while (iter.hasNext()) maintenanceList.add(makeMaintenance(iter.next()));
        return maintenanceList;
     }
}
