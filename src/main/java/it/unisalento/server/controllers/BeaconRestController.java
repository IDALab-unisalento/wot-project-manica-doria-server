package it.unisalento.server.controllers;

import it.unisalento.server.DTO.BeaconDTO;
import it.unisalento.server.DTO.StepDTO;
import it.unisalento.server.controllers.mapper.BeaconMapper;
import it.unisalento.server.controllers.mapper.StepMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/beacon")
public class BeaconRestController {

    @Autowired
    IBeaconService beaconService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BeaconDTO save(@RequestBody BeaconDTO beaconDTO) throws ObjectAlreadyExistException {
        return BeaconMapper.makeBeaconDTO(beaconService.save(BeaconMapper.makeBeacon(beaconDTO)));
    }

    @PutMapping(value = "/modify")
    public BeaconDTO complete(@RequestBody BeaconDTO beaconDTO) throws ObjectNotFoundException {
        return BeaconMapper.makeBeaconDTO(beaconService.modify(BeaconMapper.makeBeacon(beaconDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public BeaconDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return BeaconMapper.makeBeaconDTO(beaconService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<BeaconDTO> getAll(){
        return BeaconMapper.makeBeaconDTOList(beaconService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public BeaconDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return BeaconMapper.makeBeaconDTO(beaconService.getById(id));
    }
}
