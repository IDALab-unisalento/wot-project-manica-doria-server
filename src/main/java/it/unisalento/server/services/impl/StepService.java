package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Step;
import it.unisalento.server.repositories.StepRepository;
import it.unisalento.server.services.interf.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService implements IStepService {

    @Autowired
    StepRepository stepRepository;

    @Override
    public List<Step> getAllByMaintenaceId(int id) {
        return stepRepository.findAllByMaintenance_Id(id);
    }
}
