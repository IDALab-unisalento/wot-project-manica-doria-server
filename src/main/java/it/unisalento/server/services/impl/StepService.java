package it.unisalento.server.services.impl;

import it.unisalento.server.repositories.StepRepository;
import it.unisalento.server.services.interf.IStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService implements IStepService {

    @Autowired
    StepRepository stepRepository;
}
