package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatMapper {

    public static ChatDTO makeChatDTO(Chat chat) {

        ChatDTO.ChatDTOBuilder chatDTOBuilder = new ChatDTO.ChatDTOBuilder()
                .setId(chat.getId())
                .setMaintenance(MaintenanceMapper.makeMaintenanceDTO(chat.getMaintenance()));

        if(chat.getMessage() != null)
            chatDTOBuilder.setMessage(MessageMapper.makeMessageDTOList(chat.getMessage()));

        return chatDTOBuilder.build();
    }

    public static Chat makeChat(ChatDTO chatDTO){
        Chat chat =  new Chat(
                chatDTO.getId(),
                new Maintenance());

        if (chatDTO.getMaintenance() != null) {
            chat.setMaintenance(MaintenanceMapper.makeMaintenance(chatDTO.getMaintenance()));
        }

        return chat;
    }

    public static List<ChatDTO> makeChatDTOList(List<Chat> chatList) {
        Iterator<Chat> iter = chatList.iterator();
        List<ChatDTO> chatDTOList = new ArrayList<>();
        while (iter.hasNext()) chatDTOList.add(makeChatDTO(iter.next()));
        return chatDTOList;
    }

    public static List<Chat> makeChatList(List<ChatDTO> chatDTOList) {
        Iterator<ChatDTO> iter = chatDTOList.iterator();
        List<Chat> chatList = new ArrayList<>();
        while (iter.hasNext()) chatList.add(makeChat(iter.next()));
        return chatList;
    }
}
