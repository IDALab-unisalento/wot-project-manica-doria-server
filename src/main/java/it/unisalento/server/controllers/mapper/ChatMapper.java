package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Chat;
import it.unisalento.server.entities.Step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatMapper {

    public static ChatDTO makeChatDTO(Chat chat) {

        ChatDTO.ChatDTOBuilder chatDTOBuilder = new ChatDTO.ChatDTOBuilder()
                .setId(chat.getId())
                .setMaintenance(MaintenanceMapper.makeMaintenanceDTO(chat.getMaintenance()))
                .setMessage(MessageMapper.makeMessageDTOList(chat.getMessage()));
        return chatDTOBuilder.build();
    }

    public static Chat makeChat(ChatDTO chatDTO){
        return new Chat(
                chatDTO.getId(),
                MaintenanceMapper.makeMaintenance(chatDTO.getMaintenance()),
                MessageMapper.makeMessageList(chatDTO.getMessage())
        );
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
