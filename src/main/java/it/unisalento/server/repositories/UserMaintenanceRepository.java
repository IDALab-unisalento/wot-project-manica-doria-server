package it.unisalento.server.repositories;

import it.unisalento.server.entities.UserMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMaintenanceRepository extends JpaRepository<UserMaintenance, Integer> {

    List<UserMaintenance> findUserMaintenanceByUser_Id(int id);
}
