package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Message;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IMessageService {

    Message save(Message message) throws ObjectAlreadyExistException;
    Message delete(int id) throws ObjectNotFoundException;

    List<Message> getAll();
    Message getById(int id) throws ObjectNotFoundException;
}
