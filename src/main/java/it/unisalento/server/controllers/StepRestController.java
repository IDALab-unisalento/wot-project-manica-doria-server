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
}
