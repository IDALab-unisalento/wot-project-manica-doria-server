package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.controllers.mapper.MaintenanceMapper;
import it.unisalento.server.controllers.mapper.UserMapper;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/maintenance")
public class MaintenanceRestController {

    @Autowired
    IMaintenanceService maintenanceService;

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MaintenanceDTO save(@RequestBody MaintenanceDTO maintenanceDTO) throws ObjectAlreadyExistException, ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.save(MaintenanceMapper.makeMaintenance(maintenanceDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public MaintenanceDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<MaintenanceDTO> getAll(){
        return MaintenanceMapper.makeMaintenanceDTOList(maintenanceService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public MaintenanceDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.getById(id));
    }

    @GetMapping(value = "/getMaintenanceFromUser/{id}")
    public List<MaintenanceDTO> getMaintenaceFromUser(@PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTOList(maintenanceRepository.findMaintenanceByUser_Id(id));
    }

    @GetMapping(value = "/getByStatusAndUser/{status}/{id}")
    public MaintenanceDTO getByStatusAndUser(@PathVariable String status, @PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.getByStatusAndUser(status, id));
    }

    @PutMapping(value = "/start/{id_maintenance}/{id_user}")
    public MaintenanceDTO start(@PathVariable int id_maintenance, @PathVariable int id_user) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.startMaintenance(id_maintenance, id_user));
    }

    @PutMapping(value = "/complete/{id}")
    public MaintenanceDTO complete(@PathVariable int id) throws ObjectNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.completeMaintenance(id));
    }


}
