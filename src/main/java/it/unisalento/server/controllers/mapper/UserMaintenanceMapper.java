package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.UserMaintenanceDTO;
import it.unisalento.server.DTO.UserMaintenanceDTO;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.entities.UserMaintenance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserMaintenanceMapper {

    public static UserMaintenanceDTO makeUserMaintenanceDTO(UserMaintenance userMaintenance) {
        UserMaintenanceDTO.UserMaintenanceBuilderDTO userMaintenanceBuilderDTO = new UserMaintenanceDTO.UserMaintenanceBuilderDTO()
            .setId(userMaintenance.getId());
        if (userMaintenance.getMaintenance() != null) {
            userMaintenanceBuilderDTO.setMaintenance(MaintenanceMapper.makeMaintenanceDTO(userMaintenance.getMaintenance()));
        }
        if (userMaintenance.getUser() != null){
            userMaintenanceBuilderDTO.setUser(UserMapper.makeUserDTO(userMaintenance.getUser()));
        }
        return userMaintenanceBuilderDTO.build();
    }

    public static UserMaintenance makeUserMaintenance(UserMaintenanceDTO userMaintenanceDTO) {
        return new UserMaintenance(
                userMaintenanceDTO.getId(),
                UserMapper.makeUser(userMaintenanceDTO.getUser()),
                MaintenanceMapper.makeMaintenance(userMaintenanceDTO.getMaintenance())
        );
    }

    public static List<UserMaintenanceDTO> makeUserMaintenanceDTOList(List<UserMaintenance> userList) {
        Iterator<UserMaintenance> iter = userList.iterator();
        List<UserMaintenanceDTO> userMaintenanceDTOList = new ArrayList<>();
        while (iter.hasNext()) userMaintenanceDTOList.add(makeUserMaintenanceDTO(iter.next()));
        return userMaintenanceDTOList;
    }

    public static List<UserMaintenance> makeUserMaintenanceList(List<UserMaintenanceDTO> userDTOList) {
        Iterator<UserMaintenanceDTO> iter = userDTOList.iterator();
        List<UserMaintenance> userList = new ArrayList<>();
        while (iter.hasNext()) userList.add(makeUserMaintenance(iter.next()));
        return userList;
    }
}
