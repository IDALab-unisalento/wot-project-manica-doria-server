package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Step;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IStepService {

    Step save(Step step) throws ObjectNotFoundException;
    Step delete(int id) throws ObjectNotFoundException;
    Step getById(int id) throws ObjectNotFoundException;
    List<Step> getAll();

    Step completeStep(int id)  throws ObjectNotFoundException;

}
