package it.unisalento.server.repositories;

import it.unisalento.server.entities.UserMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMaintenanceRepository extends JpaRepository<UserMaintenance, Integer> {

    List<UserMaintenance> findUserMaintenanceByUser_Id(int id);
    List<UserMaintenance> findUserMaintenanceByStatusAndUser_Id(String status, int id);
    Optional<UserMaintenance> findUserMaintenanceByMaintenance_IdAndUser_Id(int id_maintenance, int id_user);
    List<UserMaintenance> findUserMaintenanceByStatus(String status);
}
