package it.unisalento.server.controllers;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.controllers.mapper.AttachmentMapper;
import it.unisalento.server.entities.Attachment;
import it.unisalento.server.exception.ObjectAlreadyExistException;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attachment")
public class AttachmentRestController {

    @Autowired
    IAttachmentService attachmentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttachmentDTO save(@RequestBody Attachment attachment) throws ObjectAlreadyExistException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.save(attachment));
    }

    @DeleteMapping(value = "/delete/{id}")
    public AttachmentDTO delete(@PathVariable int id) throws ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.delete(id));
    }

    @GetMapping(value = "/getAll")
    public List<AttachmentDTO> getAll(){
        return AttachmentMapper.makeAttachmentDTOList(attachmentService.getAll());
    }

    @GetMapping(value = "/getById/{id}")
    public AttachmentDTO getById(@PathVariable int id) throws ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.getById(id));
    }
}
