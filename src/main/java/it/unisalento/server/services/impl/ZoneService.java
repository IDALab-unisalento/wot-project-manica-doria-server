package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.BeaconRepository;
import it.unisalento.server.repositories.MachineRepository;
import it.unisalento.server.repositories.ZoneRepository;
import it.unisalento.server.services.interf.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService implements IZoneService {

    @Autowired
    ZoneRepository zoneRepository;
    @Autowired
    MachineRepository machineRepository;
    @Autowired
    BeaconRepository beaconRepository;

    @Override
    @Transactional
    public Zone save(Zone zone) throws ObjectAlreadyExistException, ObjectNotFoundException {
        if (zoneRepository.findZoneByNameAndMachine_Id(zone.getName(), zone.getMachine().getId()).isPresent())
            throw new ObjectAlreadyExistException("Zone Already Exist");
        Optional<Machine> machine = machineRepository.findById(zone.getMachine().getId());
        Optional<Beacon> beacon = beaconRepository.findById(zone.getBeacon().getId());
        if (machine.isPresent() && beacon.isPresent()) {
            zone.setMachine(machine.get());
            zone.setBeacon(beacon.get());
            return zoneRepository.save(zone);
        } else {
            throw new ObjectNotFoundException("Child Object not Found");
        }

    }

    @Override
    @Transactional
    public Zone delete(int id) throws ObjectNotFoundException {
        Optional<Zone> deleted = zoneRepository.findById(id);
        if (deleted.isPresent()) { zoneRepository.delete(deleted.get());
            return deleted.get();
        } else throw new ObjectNotFoundException("Zone Not Found");
    }

    @Override
    @Transactional
    public Zone getById(int id) throws ObjectNotFoundException {
        return zoneRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Zone with id='"+id+"' Not Found"));
    }

    @Override
    @Transactional
    public List<Zone> getAll() {
        List<Zone> zoneList = zoneRepository.findAll();
        if (zoneList.isEmpty())
            return new ArrayList<>();
        else
            return zoneList;
    }

    @Override
    public List<Zone> getAllZoneByMachine(int id) {
        List<Zone> zoneList = zoneRepository.findAllByMachine_IdOrderByName(id);
        if (zoneList.isEmpty())
            return new ArrayList<>();
        else
            return zoneList;
    }
}
