package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Step;
import it.unisalento.server.exception.UserNotFoundException;

import java.util.List;

public interface IStepService {

    Step save(Step step);
    Step delete(int id) throws UserNotFoundException;
    Step getById(int id) throws UserNotFoundException;
    List<Step> getAll();

}
