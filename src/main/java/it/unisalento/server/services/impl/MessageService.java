package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Message;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements IMessageService {
    @Override
    public Message save(Message message) throws ObjectAlreadyExistException {
        return null;
    }

    @Override
    public Message delete(int id) throws ObjectNotFoundException {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return null;
    }

    @Override
    public Message getById(int id) throws ObjectNotFoundException {
        return null;
    }
}
