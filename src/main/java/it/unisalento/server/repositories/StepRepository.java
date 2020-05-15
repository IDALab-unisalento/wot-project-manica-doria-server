package it.unisalento.server.repositories;

import it.unisalento.server.entities.Step;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Integer> {
}
