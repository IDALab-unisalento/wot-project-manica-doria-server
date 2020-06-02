package it.unisalento.server.controllers;

import it.unisalento.server.DTO.MachineDTO;
import it.unisalento.server.DTO.MessageDTO;
import it.unisalento.server.controllers.mapper.MachineMapper;
import it.unisalento.server.controllers.mapper.MessageMapper;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/message")
public class MessageRestController {

    @Autowired
    IMessageService messageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO save(@RequestBody MessageDTO messageDTO) throws ObjectAlreadyExistException {
        return MessageMapper.makeMessageDTO(messageService.save(MessageMapper.makeMessage(messageDTO)));
    }

    @DeleteMapping(value = "/delete/{id}")
    public MessageDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return MessageMapper.makeMessageDTO(messageService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<MessageDTO> getAll(){
        return MessageMapper.makeMessageDTOList(messageService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public MessageDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return MessageMapper.makeMessageDTO(messageService.getById(id));
    }
}
