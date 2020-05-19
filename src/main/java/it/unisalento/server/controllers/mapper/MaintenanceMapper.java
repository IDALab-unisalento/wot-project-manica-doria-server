package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.entities.Maintenance;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MaintenanceMapper {

     public static MaintenanceDTO makeMaintenanceDTO(Maintenance maintenance) {
         MaintenanceDTO.MaintenanceDTOBuilder maintenanceDTOBuilder = new MaintenanceDTO.MaintenanceDTOBuilder()
                 .setId(maintenance.getId())
                 .setStatus(maintenance.getStatus())
                 .setDate(maintenance.getDate())
                 .setUser(UserMapper.makeUserDTO(maintenance.getUser()));

         return maintenanceDTOBuilder.build();
     }

     public static Maintenance makeMaintenance(MaintenanceDTO maintenanceDTO) {
         return new Maintenance(
                 maintenanceDTO.getId(),
                 maintenanceDTO.getStatus(),
                 maintenanceDTO.getDate(),
                 MachineMapper.makeMachine(maintenanceDTO.getMachine()),
                 UserMapper.makeUser(maintenanceDTO.getUser())
         );
     }

     public static List<MaintenanceDTO> makeUserDTOList(List<Maintenance> userList) {
        Iterator<Maintenance> iter = userList.iterator();
        List<MaintenanceDTO> maintenanceDTOList = new ArrayList<>();
        while (iter.hasNext()) maintenanceDTOList.add(makeMaintenanceDTO(iter.next()));
        return maintenanceDTOList;
     }

     public static List<Maintenance> makeUserList(List<MaintenanceDTO> userDTOList) {
        Iterator<MaintenanceDTO> iter = userDTOList.iterator();
        List<Maintenance> maintenanceList = new ArrayList<>();
        while (iter.hasNext()) maintenanceList.add(makeMaintenance(iter.next()));
        return maintenanceList;
     }

}
