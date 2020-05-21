package it.unisalento.server.repositories;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    Optional<Zone> findByNameAndBeacon_mac(String name, String mac);
}
