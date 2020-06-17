package it.unisalento.server.controllers;

import it.unisalento.server.DTO.StepDTO;
import it.unisalento.server.DTO.ZoneDTO;
import it.unisalento.server.controllers.mapper.StepMapper;
import it.unisalento.server.controllers.mapper.ZoneMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
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
    public ZoneDTO save(@RequestBody ZoneDTO zoneDTO) throws ObjectAlreadyExistException, ObjectNotFoundException {
        return ZoneMapper.makeZoneDTO(zoneService.save(ZoneMapper.makeZone(zoneDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ZoneDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return ZoneMapper.makeZoneDTO(zoneService.delete(id));
    }

    @GetMapping(value = "/getById/{id}")
    public ZoneDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return ZoneMapper.makeZoneDTO(zoneService.getById(id));
    }

    @GetMapping(value = "/getAll")
    public List<ZoneDTO> getAll(){
        return ZoneMapper.makeZoneDTOList(zoneService.getAll());
    }

    @GetMapping(value = "/getAllByMachineId/{id}")
    public List<ZoneDTO> getAllByMachineId(@PathVariable int id) { return ZoneMapper.makeZoneDTOList(zoneService.getAllZoneByMachine(id));}

}
