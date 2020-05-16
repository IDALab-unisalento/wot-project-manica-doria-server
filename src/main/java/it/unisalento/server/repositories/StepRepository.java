package it.unisalento.server.repositories;

import it.unisalento.server.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer> {

    List<Step> findAllByMaintenance_Id(int id);

}
