package it.unisalento.server.services.impl;

import it.unisalento.server.entities.User;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
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

    @Override
    @Transactional
    public Zone save(Zone zone) throws UserAlreadyExistException {
        if (zoneRepository.findByNameAndBeacon_mac(zone.getName(), zone.getBeacon().getMac()).isPresent())
            throw new UserAlreadyExistException("Zone Already Exist");
        else
            return zoneRepository.save(zone);
    }

    @Override
    @Transactional
    public Zone delete(int id) throws UserNotFoundException {
        Optional<Zone> deleted = zoneRepository.findById(id);
        if (deleted.isPresent()) { zoneRepository.delete(deleted.get());
            return deleted.get();
        } else throw new UserNotFoundException("Zone Not Found");
    }

    @Override
    @Transactional
    public Zone getById(int id) throws UserNotFoundException {
        return zoneRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Zone with id='"+id+"' Not Found"));
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
}
