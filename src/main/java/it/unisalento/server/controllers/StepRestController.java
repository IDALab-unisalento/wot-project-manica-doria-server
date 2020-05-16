package it.unisalento.server.controllers;

import it.unisalento.server.entities.Step;
import it.unisalento.server.services.interf.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/step")
public class StepRestController {

    @Autowired
    IStepService stepService;

    @RequestMapping(value = "/getAllByMaintenanceId/{id}", method = RequestMethod.GET)
    public List<Step> getAllVoti(@PathVariable int id) {
        return stepService.getAllByMaintenaceId(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Step save(@RequestBody Step step) {
        return stepService.save(step);
    }

}
