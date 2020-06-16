package it.unisalento.server.controllers;

import it.unisalento.server.DTO.ChatDTO;
import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.DTO.MessageDTO;
import it.unisalento.server.controllers.mapper.ChatMapper;
import it.unisalento.server.controllers.mapper.MachineMapper;
import it.unisalento.server.controllers.mapper.MessageMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatRestController {

    @Autowired
    IChatService chatService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChatDTO save(@RequestBody ChatDTO chatDTO) throws ObjectAlreadyExistException {
        return ChatMapper.makeChatDTO(chatService.save(ChatMapper.makeChat(chatDTO)));
    }

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO save(@RequestBody MessageDTO messageDTO) throws ObjectAlreadyExistException {
        return MessageMapper.makeMessageDTO(chatService.sendMessage(MessageMapper.makeMessage(messageDTO)));
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
}
