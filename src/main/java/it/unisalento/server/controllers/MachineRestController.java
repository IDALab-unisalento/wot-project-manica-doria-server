package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.controllers.mapper.MachineMapper;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/machine")
public class MachineRestController {

    @Autowired
    IMachineService machineService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MachineDTO save(@RequestBody MachineDTO machineDTO) throws UserAlreadyExistException {
        return MachineMapper.makeMachineDTO(machineService.save(MachineMapper.makeMachine(machineDTO)));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MachineDTO delete(@PathVariable int id) throws UserNotFoundException {
        return MachineMapper.makeMachineDTO(machineService.delete(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<MachineDTO> getAll(){
        return MachineMapper.makeMachineDTOList(machineService.getAll());
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public MachineDTO getById(@PathVariable int id) throws UserNotFoundException {
        return MachineMapper.makeMachineDTO(machineService.getById(id));
    }
}
