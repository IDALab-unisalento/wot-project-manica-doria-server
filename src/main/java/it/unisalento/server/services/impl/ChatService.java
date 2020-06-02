package it.unisalento.server.services.impl;

import it.unisalento.server.entities.*;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.ChatRepository;
import it.unisalento.server.repositories.MaintenanceRepository;
import it.unisalento.server.services.interf.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService implements IChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    public Chat save(Chat chat) throws ObjectAlreadyExistException {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(chat.getMaintenance().getId());
        if (maintenance.isPresent()) {
            chat.setMaintenance(maintenance.get());
            return chatRepository.save(chat);
        } else {
            throw new ObjectAlreadyExistException("Child Object not Found");
        }
    }

    @Override
    public Chat delete(int id) throws ObjectNotFoundException {
        Optional<Chat> deleted = chatRepository.findById(id);
        if (deleted.isPresent()) {
            chatRepository.delete(deleted.get());
            return deleted.get();
        } else
            throw new ObjectNotFoundException("Chat Not Found");
    }

    @Override
    public List<Chat> getAll() {
        return chatRepository.findAll();
    }


    @Override
    public Chat getByMaintenance(int id) {
        return chatRepository.findChatByMaintenance_Id(id);
    }

    @Override
    public Chat getById(int id) throws ObjectNotFoundException {
        return chatRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Chat with id='"+id+"' Not Found"));
    }

}
