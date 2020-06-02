package it.unisalento.server.controllers;

import it.unisalento.server.repositories.ChatRepository;
import it.unisalento.server.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatRestController {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MessageRepository messageRepository;

}
