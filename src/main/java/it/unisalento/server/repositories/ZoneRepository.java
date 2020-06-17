package it.unisalento.server.repositories;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    Optional<Zone> findZoneByNameAndMachine_Id(String name, int id_machine);

    List<Zone> findAllByMachine_IdOrderByName(int id);
}
