package it.unisalento.server.controllers;

import it.unisalento.server.entities.Zone;
import it.unisalento.server.services.interf.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/zone")
public class ZoneRestController {

    @Autowired
    IZoneService zoneService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Zone save(@RequestBody Zone zone) {
        return zoneService.save(zone);
    }
}
