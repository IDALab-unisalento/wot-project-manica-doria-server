package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.MessageDTO;
import it.unisalento.server.DTO.MessageDTO;
import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Message;
import it.unisalento.server.entities.Message;
import it.unisalento.server.entities.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageMapper {

    public static MessageDTO makeMessageDTO(Message message) {
        MessageDTO.MessageDTOBuilder messageDTOBuilder = new MessageDTO.MessageDTOBuilder()
                .setId(message.getId())
                .setContent(message.getContent())
                .setDate(message.getDate())
                .setUser(UserMapper.makeUserDTO(message.getUser()));
        return messageDTOBuilder.build();
    }

    public static Message makeMessage(MessageDTO messageDTO) {
        Message message =  new Message(
                messageDTO.getId(),
                messageDTO.getContent(),
                messageDTO.getDate(),
                new User(),
                new Chat());

        if (messageDTO.getUser() != null) {
            message.setUser(UserMapper.makeUser(messageDTO.getUser()));
        }
        if (messageDTO.getChat() != null) {
            message.setChat(ChatMapper.makeChat(messageDTO.getChat()));
        }

        return message;
    }

    public static List<MessageDTO> makeMessageDTOList(List<Message> chatList) {
        Iterator<Message> iter = chatList.iterator();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        while (iter.hasNext()) messageDTOList.add(makeMessageDTO(iter.next()));
        return messageDTOList;
    }

    public static List<Message> makeMessageList(List<MessageDTO> messageDTOList) {
        Iterator<MessageDTO> iter = messageDTOList.iterator();
        List<Message> messageList = new ArrayList<>();
        while (iter.hasNext()) messageList.add(makeMessage(iter.next()));
        return messageList;
    }
}
