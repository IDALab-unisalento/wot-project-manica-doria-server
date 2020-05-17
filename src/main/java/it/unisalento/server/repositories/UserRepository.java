package it.unisalento.server.repositories;

import it.unisalento.server.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    List<User> findAllByRole(String role);
    Optional<User> findByEmailAndSerialNumber(String email, String serialNumber);
}
