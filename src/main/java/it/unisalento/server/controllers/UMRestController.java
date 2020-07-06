package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.DTO.UserMaintenanceDTO;
import it.unisalento.server.controllers.mapper.MaintenanceMapper;
import it.unisalento.server.controllers.mapper.UserMaintenanceMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IUserMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/user/maintenance")
public class UMRestController {

    @Autowired
    private IUserMaintenanceService userMaintenanceService;

    @GetMapping(value = "/getAll")
    public List<UserMaintenanceDTO> getAll(){
        return UserMaintenanceMapper.makeUserMaintenanceDTOList(userMaintenanceService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public UserMaintenanceDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(userMaintenanceService.getUserMaintenanceById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserMaintenanceDTO save(@RequestBody UserMaintenanceDTO userMaintenanceDTO) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(
                userMaintenanceService.save(UserMaintenanceMapper.makeUserMaintenance(userMaintenanceDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public UserMaintenanceDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(userMaintenanceService.delete(id));
    }

    @GetMapping(value = "/getMaintenanceFromUser/{id}")
    public List<UserMaintenanceDTO> getMaintenaceFromUser(@PathVariable int id) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTOList(userMaintenanceService.getAllByUserId(id));
    }

    @GetMapping(value = "/getByStatusAndUser/{status}/{id}")
    public List<UserMaintenanceDTO> getByStatusAndUser(@PathVariable String status, @PathVariable int id) {
        return UserMaintenanceMapper.makeUserMaintenanceDTOList(userMaintenanceService.getByStatusAndUser(status, id));
    }

    @GetMapping(value = "/getAllByStatus/{status}")
    public List<UserMaintenanceDTO> getByStatusAndUser(@PathVariable String status) {
        return UserMaintenanceMapper.makeUserMaintenanceDTOList(userMaintenanceService.getAllByStatus(status));
    }


    @PutMapping(value = "/start/{id_maintenance}/{id_user}")
    public UserMaintenanceDTO start(@PathVariable int id_maintenance, @PathVariable int id_user) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(userMaintenanceService.startMaintenance(id_maintenance, id_user));
    }

    @PutMapping(value = "/complete/{id}")
    public UserMaintenanceDTO complete(@PathVariable int id) throws ObjectNotFoundException {
        return UserMaintenanceMapper.makeUserMaintenanceDTO(userMaintenanceService.completeMaintenance(id));
    }

}
