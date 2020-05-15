package it.unisalento.server.services.impl;

import it.unisalento.server.repositories.BeaconRepository;
import it.unisalento.server.services.interf.IBeaconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeaconService implements IBeaconService {

    @Autowired
    BeaconRepository beaconRepository;
}
