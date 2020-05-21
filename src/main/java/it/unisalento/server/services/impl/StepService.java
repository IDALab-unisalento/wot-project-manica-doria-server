package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.repositories.StepRepository;
import it.unisalento.server.services.interf.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StepService implements IStepService {

    @Autowired
    StepRepository stepRepository;

    @Override
    public Step save(Step step) {
        return stepRepository.save(step);
    }

    @Override
    public Step delete(int id) throws UserNotFoundException {
        Optional<Step> deleted = stepRepository.findById(id);
        if (deleted.isPresent()) { stepRepository.delete(deleted.get());
            return deleted.get();
        } else throw new UserNotFoundException("Step Not Found");
    }

    @Override
    public Step getById(int id) throws UserNotFoundException {
        return stepRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Zone with id='"+id+"' Not Found"));
    }

    @Override
    public List<Step> getAll() {
        List<Step> stepList = stepRepository.findAll();
        if (stepList.isEmpty())
            return new ArrayList<>();
        else
            return stepList;
    }
}
