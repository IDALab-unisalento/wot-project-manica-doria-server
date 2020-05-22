package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.controllers.mapper.MaintenanceMapper;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/maintenance")
public class MaintenanceRestController {

    @Autowired
    IMaintenanceService maintenanceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MaintenanceDTO save(@RequestBody Maintenance maintenance) throws UserAlreadyExistException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.save(maintenance));
    }

    @DeleteMapping(value = "/delete/{id}")
    public MaintenanceDTO delete(@PathVariable int id) throws UserNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<MaintenanceDTO> getAll(){
        return MaintenanceMapper.makeMaintenanceDTOList(maintenanceService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public MaintenanceDTO getById(@PathVariable int id) throws UserNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.getById(id));
    }
}
