package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Message;
import it.unisalento.server.entities.User;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.ChatRepository;
import it.unisalento.server.repositories.MessageRepository;
import it.unisalento.server.repositories.UserRepository;
import it.unisalento.server.services.interf.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements IMessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;


    @Override
    public Message save(Message message) throws ObjectAlreadyExistException {
        Optional<Chat> chat = chatRepository.findById(message.getChat().getId());
        Optional<User> user = userRepository.findById(message.getUser().getId());
        System.out.println(chat);
        System.out.println(user);
        if (chat.isPresent() && user.isPresent()) {
            message.setChat(chat.get());
            message.setUser(user.get());
            return messageRepository.save(message);
        } else {
            throw new ObjectAlreadyExistException("Child Object not Found");
        }
    }

    @Override
    public Message delete(int id) throws ObjectNotFoundException {
        Optional<Message> deleted = messageRepository.findById(id);
        if (deleted.isPresent()) {
            messageRepository.delete(deleted.get());
            return deleted.get();
        } else
            throw new ObjectNotFoundException("Chat Not Found");
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message getById(int id) throws ObjectNotFoundException {
        return messageRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Message with id='"+id+"' Not Found"));
    }
}
