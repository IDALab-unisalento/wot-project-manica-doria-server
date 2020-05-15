package it.unisalento.server.repositories;

import it.unisalento.server.entities.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconRepository extends JpaRepository<Beacon, Integer> {
}
