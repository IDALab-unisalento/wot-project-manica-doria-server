package it.unisalento.server.DTO;

import it.unisalento.server.entities.Chat;

import java.util.Date;
import java.util.List;

public class MessageDTO {

    private int id;
    private String content;
    private Date date;
    private UserDTO user;
    private ChatDTO chat;

    private MessageDTO(int id, String content, Date date, UserDTO user,  ChatDTO  chat) {
        this.id = id;
        this.content = content;
        this.date = date;
        this.user = user;
        this.chat = chat;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public UserDTO getUser() {
        return user;
    }

    public ChatDTO getChatList() {
        return chat;
    }

    public static class MessageDTOBuilder {
        private int id;
        private String content;
        private Date date;
        private UserDTO user;
        private ChatDTO chat;

        public MessageDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MessageDTOBuilder setContent(String content) {
            this.content = content;
            return this;
        }

        public MessageDTOBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public MessageDTOBuilder setUser(UserDTO user) {
            this.user = user;
            return this;
        }

        public MessageDTOBuilder setChatList(ChatDTO chat) {
            this.chat = chat;
            return this;
        }

        public MessageDTO build() {
            return new MessageDTO(id, content, date, user, chat);
        }
    }
}
