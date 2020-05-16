package it.unisalento.server.controllers;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.services.interf.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/machine")
public class MachineRestController {

    @Autowired
    IMachineService machineService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Machine> getAll(){
        return machineService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Machine save(@RequestBody Machine machine) {
        return machineService.save(machine);
    }

}
