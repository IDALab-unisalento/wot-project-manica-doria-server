package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MaintenanceDTO;
import it.unisalento.server.controllers.mapper.MaintenanceMapper;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/maintenance")
public class MaintenanceRestController {

    @Autowired
    IMaintenanceService maintenanceService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MaintenanceDTO save(@RequestBody MaintenanceDTO maintenanceDTO) throws UserAlreadyExistException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.save(MaintenanceMapper.makeMaintenance(maintenanceDTO)));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MaintenanceDTO delete(@PathVariable int id) throws UserNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.delete(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<MaintenanceDTO> getAll(){
        return MaintenanceMapper.makeMaintenanceDTOList(maintenanceService.getAll());
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public MaintenanceDTO getById(@PathVariable int id) throws UserNotFoundException {
        return MaintenanceMapper.makeMaintenanceDTO(maintenanceService.getById(id));
    }
}
