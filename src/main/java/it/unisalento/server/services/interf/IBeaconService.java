package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Beacon;

import java.util.List;
import java.util.Optional;

public interface IBeaconService {

    Beacon save(Beacon beacon);
    List<Beacon> getAll();
    void delete(Beacon beacon);
    Optional<Beacon> getById(int id);
}
