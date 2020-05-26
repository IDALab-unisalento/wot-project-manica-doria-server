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
                 .setStatus(maintenance.getStatus())
                 .setDate(maintenance.getDate())
                 .setType(maintenance.getType());
         if (maintenance.getMachine() != null)
            maintenanceDTOBuilder.setMachine(MachineMapper.makeMachineDTO(maintenance.getMachine()));
         
         if (maintenance.getUser() != null)
            maintenanceDTOBuilder.setUser(UserMapper.makeUserDTO(maintenance.getUser()));

         return maintenanceDTOBuilder.build();
     }

     public static Maintenance makeMaintenance(MaintenanceDTO maintenanceDTO) {
         Maintenance maintenance = new Maintenance(
                 maintenanceDTO.getId(),
                 maintenanceDTO.getStatus(),
                 maintenanceDTO.getDate(),
                 maintenanceDTO.getType(),
                 new Machine(),
                 new User());

         if (maintenanceDTO.getMachine() != null) {
             maintenance.setMachine(MachineMapper.makeMachine(maintenanceDTO.getMachine()));
         }
         if (maintenanceDTO.getUser() != null) {
             maintenance.setUser(UserMapper.makeUser(maintenanceDTO.getUser()));
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
