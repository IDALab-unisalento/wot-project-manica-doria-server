package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.repositories.BeaconRepository;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeaconService implements IBeaconService {

    @Autowired
    BeaconRepository beaconRepository;

    @Override
    public Beacon save(Beacon beacon) {
        return beaconRepository.save(beacon);
    }

    @Override
    public List<Beacon> getAll() {
        return beaconRepository.findAll();
    }

    @Override
    public void delete(Beacon beacon) {
        beaconRepository.delete(beacon);
    }

    @Override
    public Optional<Beacon> getById(int id) {
        return beaconRepository.findById(id);
    }
}
