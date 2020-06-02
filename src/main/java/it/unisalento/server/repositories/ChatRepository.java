package it.unisalento.server.repositories;

import it.unisalento.server.entities.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    Chat findChatByMaintenance_Id(int id);
}
