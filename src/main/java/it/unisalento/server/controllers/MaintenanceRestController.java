package it.unisalento.server.controllers;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.services.interf.IMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/maintenance")
public class MaintenanceRestController {

    @Autowired
    IMaintenanceService maintenanceService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Maintenance> getAll(){
        return maintenanceService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Maintenance save(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }
}
