package it.unisalento.server.controllers;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/beacon")
public class BeaconRestController {

    @Autowired
    IBeaconService beaconService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Beacon save(@RequestBody Beacon beacon) {
        return beaconService.save(beacon);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Beacon> getAll(){
        return beaconService.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody Beacon beacon) {
        beaconService.delete(beacon);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Optional<Beacon> getById(@PathVariable int id) {
        return beaconService.getById(id);
    }


}
