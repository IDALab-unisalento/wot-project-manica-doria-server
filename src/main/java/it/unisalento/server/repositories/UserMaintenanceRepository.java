package it.unisalento.server.repositories;

import it.unisalento.server.entities.UserMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMaintenanceRepository extends JpaRepository<UserMaintenance, Integer> {

    List<UserMaintenance> findUserMaintenanceByUser_Id(int id);
}
