package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Zone;
import it.unisalento.server.repositories.ZoneRepository;
import it.unisalento.server.services.interf.IZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZoneService implements IZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public Zone save(Zone zone) {
        return zoneRepository.save(zone);
    }
}
