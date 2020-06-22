package it.unisalento.server.controllers;

import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.DTO.MessageDTO;
import it.unisalento.server.controllers.mapper.ChatMapper;
import it.unisalento.server.controllers.mapper.MessageMapper;
import it.unisalento.server.entities.Message;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatRestController {

    @Autowired
    private IChatService chatService;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/{maintenanceId}")
    public void greeting(MessageDTO messageDTO, @DestinationVariable int maintenanceId) throws ObjectNotFoundException {
        this.chatService.saveMessage(MessageMapper.makeMessage(messageDTO));
        messagingTemplate.convertAndSend("/topic/greetings/" + maintenanceId, messageDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatDTO save(@RequestBody ChatDTO chatDTO) throws ObjectAlreadyExistException {
        return ChatMapper.makeChatDTO(chatService.save(ChatMapper.makeChat(chatDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ChatDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return ChatMapper.makeChatDTO(chatService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<ChatDTO> getAll(){
        return ChatMapper.makeChatDTOList(chatService.getAll());
    }

    @GetMapping(value = "/getByMaintenanceId/{id}")
    public ChatDTO getByMaintenance(@PathVariable int id) {
        return ChatMapper.makeChatDTO(chatService.getByMaintenance(id));
    }

    @GetMapping(value = "/getById/{id}")
    public ChatDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return ChatMapper.makeChatDTO(chatService.getById(id));
    }

    public String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        return dateFormat.format(date);
    }
}
