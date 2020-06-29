package it.unisalento.server.controllers;

import it.unisalento.server.DTO.StepDTO;
import it.unisalento.server.controllers.mapper.StepMapper;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/step")
public class StepRestController {

    @Autowired
    IStepService stepService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StepDTO save(@RequestBody StepDTO stepDTO) throws ObjectNotFoundException {
        return StepMapper.makeStepDTO(stepService.save(StepMapper.makeStep(stepDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public StepDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return StepMapper.makeStepDTO(stepService.delete(id));
    }

    @GetMapping(value = "/getById/{id}")
    public StepDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return StepMapper.makeStepDTO(stepService.getById(id));
    }

    @GetMapping(value = "/getAll")
    public List<StepDTO> getAll(){
        return StepMapper.makeStepDTOList(stepService.getAll());
    }

    @GetMapping(value = "/getByMaintenanceId/{id}")
    public List<StepDTO> getByMaintenanceId(@PathVariable int id) { return StepMapper.makeStepDTOList(stepService.getByMaintenanceId(id));}

    @GetMapping(value = "/getByZoneId/{id}")
    public List<StepDTO> getByZoneId(@PathVariable int id) { return StepMapper.makeStepDTOList(stepService.getByZoneId(id));}

    @PutMapping(value = "/complete/{duration}/{id_step}/{id_maintenance}/{id_user_maintenance}")
    public StepDTO complete(@PathVariable double duration, @PathVariable int id_step, @PathVariable int id_maintenance,  @PathVariable int id_user_maintenance) throws ObjectNotFoundException {
        return StepMapper.makeStepDTO(stepService.completeStep(duration, id_step, id_maintenance, id_user_maintenance));
    }
}
