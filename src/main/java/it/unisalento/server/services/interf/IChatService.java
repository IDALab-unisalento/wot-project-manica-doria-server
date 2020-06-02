package it.unisalento.server.services.interf;


import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IChatService {

    Chat save(Chat chat) throws ObjectAlreadyExistException;
    Chat delete(int id) throws ObjectNotFoundException;

    List<Chat> getAll();
    Chat getById(int id) throws ObjectNotFoundException;
    Chat getByMaintenance(int id);
}
