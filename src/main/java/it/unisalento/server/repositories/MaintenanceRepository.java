package it.unisalento.server.repositories;

import it.unisalento.server.entities.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {

    //List<Maintenance> findMaintenanceByUser_Id(int id);
    //List<Maintenance> findMaintenanceByStatusAndUser_Id(String status, int id);
    //Optional<Maintenance> findMaintenanceByIdAndUser_Id(int id_maintenance, int id_user);
    List<Maintenance> findMaintenanceByMachine_Id(int id_machine);
}
