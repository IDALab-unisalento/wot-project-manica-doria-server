package it.unisalento.server.controllers;

import it.unisalento.server.DTO.UserDTO;
import it.unisalento.server.DTO.ZoneDTO;
import it.unisalento.server.controllers.mapper.ZoneMapper;
import it.unisalento.server.controllers.mapper.ZoneMapper;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/zone")
public class ZoneRestController {

    @Autowired
    IZoneService zoneService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ZoneDTO save(@RequestBody Zone zone) throws UserAlreadyExistException {
        return ZoneMapper.makeZoneDTO(zoneService.save(zone));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ZoneDTO delete(@PathVariable int id) throws UserNotFoundException {
        return ZoneMapper.makeZoneDTO(zoneService.delete(id));
    }

    @GetMapping(value = "/getById/{id}")
    public ZoneDTO getById(@PathVariable int id) throws UserNotFoundException {
        return ZoneMapper.makeZoneDTO(zoneService.getById(id));
    }

    @GetMapping(value = "/getAll")
    public List<ZoneDTO> getAll(){
        return ZoneMapper.makeZoneDTOList(zoneService.getAll());
    }
}
