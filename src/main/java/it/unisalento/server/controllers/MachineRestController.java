package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.DTO.StepDTO;
import it.unisalento.server.controllers.mapper.MachineMapper;
import it.unisalento.server.controllers.mapper.StepMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IMachineService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/machine")
public class MachineRestController {

    @Autowired
    IMachineService machineService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MachineDTO save(@RequestBody MachineDTO machineDTO) throws ObjectAlreadyExistException {
        return MachineMapper.makeMachineDTO(machineService.save(MachineMapper.makeMachine(machineDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public MachineDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return MachineMapper.makeMachineDTO(machineService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<MachineDTO> getAll(){
        return MachineMapper.makeMachineDTOList(machineService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public MachineDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return MachineMapper.makeMachineDTO(machineService.getById(id));
    }

    @PutMapping(value = "change/{id_machine}/{status}")
    public MachineDTO changeStatusMachine(@PathVariable String status, @PathVariable int id_machine) {
        throw new NotYetImplementedException("Methods not implemented");
    }
}
