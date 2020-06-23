package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.repositories.StepRepository;
import it.unisalento.server.repositories.ZoneRepository;
import it.unisalento.server.services.interf.IMaintenanceService;
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
    @Autowired
    MaintenanceRepository maintenanceRepository;
    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    IMaintenanceService maintenanceService;

    @Override
    public Step save(Step step) throws ObjectNotFoundException {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(step.getMaintenance().getId());
        Optional<Zone> zone = zoneRepository.findById(step.getZone().getId());

        if (maintenance.isPresent() && zone.isPresent()){
            step.setMaintenance(maintenance.get());
            step.setZone(zone.get());
            return stepRepository.save(step);
        }
        else {
            throw new ObjectNotFoundException("Child Object not Found");
        }

    }

    @Override
    public Step delete(int id) throws ObjectNotFoundException {
        Optional<Step> deleted = stepRepository.findById(id);
        if (deleted.isPresent()) {
            stepRepository.delete(deleted.get());
            return deleted.get();
        } else
            throw new ObjectNotFoundException("Step Not Found");
    }

    @Override
    public Step getById(int id) throws ObjectNotFoundException {
        return stepRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Zone with id='"+id+"' Not Found"));
    }

    @Override
    public List<Step> getAll() {
        List<Step> stepList = stepRepository.findAll();
        if (stepList.isEmpty())
            return new ArrayList<>();
        else
            return stepList;
    }

    @Override
    public List<Step> getByMaintenanceId(int id) {
        List<Step> stepList = stepRepository.findAllByMaintenance_IdOrderByName(id);
        if (stepList.isEmpty())
            return new ArrayList<>();
        else
            return stepList;
    }

    @Override
    public Step completeStep(double duration, int id_step, int id_maintenance) throws ObjectNotFoundException {
        Optional<Step> completed = stepRepository.findById(id_step);
        List<Step> stepList = stepRepository.findAllByMaintenance_IdOrderByName(id_maintenance);
        if (completed.isPresent()) {
            for(int i = 0; i < stepList.size(); i ++) {
                if (stepList.get(i).getId() == (completed.get().getId())) {
                    if(i != (stepList.size() - 1)) {
                        stepList.get(i + 1).setStatus("started");
                    } else {
                        maintenanceService.completeMaintenance(id_maintenance);
                    }
                }
            }
            completed.get().setStatus("completed");
            completed.get().setDuration(duration);
            return stepRepository.save(completed.get());
        }
        else throw new ObjectNotFoundException("Step Not Found");
    }
}
