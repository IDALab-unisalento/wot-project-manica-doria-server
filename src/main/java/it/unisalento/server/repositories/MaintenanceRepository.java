package it.unisalento.server.repositories;

import it.unisalento.server.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

    List<Maintenance> findMaintenanceByUser_Id(int id);
    Optional<Maintenance> findMaintenanceByStatusAndUser_Id(String status, int id);
}
