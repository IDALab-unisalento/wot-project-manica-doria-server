package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Step;

import java.util.List;

public interface IStepService {

    List<Step> getAllByMaintenaceId(int id);
    Step save(Step step);
}
