package it.unisalento.server.repositories;

import it.unisalento.server.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Integer> {

    Optional<Machine> findBySerialNumber(String serialNumber);
}
