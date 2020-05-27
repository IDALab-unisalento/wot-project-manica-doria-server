package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.DTO.UserMaintenanceDTO;
import it.unisalento.server.controllers.mapper.MaintenanceMapper;
import it.unisalento.server.controllers.mapper.UserMaintenanceMapper;
import it.unisalento.server.controllers.mapper.UserMapper;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.UserMaintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IUserMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user/maintenace")
public class UMController {

    @Autowired
    private IUserMaintenanceService userMaintenanceService;

    @GetMapping()
    public List<UserMaintenanceDTO> getAll(){
        return UserMaintenanceMapper.makeUserMaintenanceDTOList(userMaintenanceService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public List<MaintenanceDTO> getById(@PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTOList(userMaintenanceService.getUserMaintenanceById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserMaintenanceDTO save(@RequestBody UserMaintenanceDTO userMaintenanceDTO) throws ObjectAlreadyExistException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(
                userMaintenanceService.save(UserMaintenanceMapper.makeUserMaintenance(userMaintenanceDTO)));
    }

}
