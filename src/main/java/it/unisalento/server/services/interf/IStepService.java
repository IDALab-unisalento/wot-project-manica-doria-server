package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Step;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IStepService {

    Step save(Step step) throws ObjectNotFoundException;
    Step delete(int id) throws ObjectNotFoundException;
    Step getById(int id) throws ObjectNotFoundException;
    List<Step> getAll();

    List<Step> getByMaintenanceId(int id);
    List<Step> getByZoneId(int id);
    Step completeStep(double duration, int id_step, int id_maintenance, int id_user_maintenance)  throws ObjectNotFoundException;

}
