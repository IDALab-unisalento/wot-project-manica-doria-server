package it.unisalento.server.controllers;

import it.unisalento.server.DTO.BeaconDTO;
import it.unisalento.server.controllers.mapper.BeaconMapper;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/beacon")
public class BeaconRestController {

    @Autowired
    IBeaconService beaconService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BeaconDTO save(@RequestBody BeaconDTO beaconDTO) throws UserAlreadyExistException {
        return BeaconMapper.makeBeaconDTO(beaconService.save(BeaconMapper.makeBeacon(beaconDTO)));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BeaconDTO delete(@PathVariable int id) throws UserNotFoundException {
        return BeaconMapper.makeBeaconDTO(beaconService.delete(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<BeaconDTO> getAll(){
        return BeaconMapper.makeBeaconDTOList(beaconService.getAll());
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public BeaconDTO getById(@PathVariable int id) throws UserNotFoundException {
        return BeaconMapper.makeBeaconDTO(beaconService.getById(id));
    }
}
