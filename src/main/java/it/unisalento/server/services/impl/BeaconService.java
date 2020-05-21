package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.repositories.BeaconRepository;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BeaconService implements IBeaconService {

    @Autowired
    BeaconRepository beaconRepository;

    @Override
    @Transactional
    public Beacon save(Beacon beacon) throws UserAlreadyExistException {
        if(beaconRepository.findByMac(beacon.getMac()).isPresent())
            throw new UserAlreadyExistException("Beacon Already Exist");
        else
            return beaconRepository.save(beacon);
    }

    @Override
    @Transactional
    public Beacon delete(int id) throws UserNotFoundException {
        Optional<Beacon> beacon = beaconRepository.findById(id);
        if(beacon.isPresent()) {
            beaconRepository.delete(beacon.get());
            return beacon.get();
        }
        else
            throw new UserNotFoundException("Beacon does not found");
    }

    @Override
    @Transactional
    public List<Beacon> getAll() {
        return beaconRepository.findAll();
    }

    @Override
    @Transactional
    public Beacon getById(int id) throws UserNotFoundException {
        return beaconRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Beacon with id='"+id+"' Not Found"));
    }
}
