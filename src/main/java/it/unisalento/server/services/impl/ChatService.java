package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Chat;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService implements IChatService {
    @Override
    public Chat save(Chat chat) throws ObjectAlreadyExistException {
        return null;
    }

    @Override
    public Chat delete(int id) throws ObjectNotFoundException {
        return null;
    }

    @Override
    public List<Chat> getAll() {
        return null;
    }

    @Override
    public Chat getById(int id) throws ObjectNotFoundException {
        return null;
    }
}
