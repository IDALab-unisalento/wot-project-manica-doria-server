package it.unisalento.server.controllers;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.DTO.BeaconDTO;
import it.unisalento.server.controllers.mapper.AttachmentMapper;
import it.unisalento.server.controllers.mapper.BeaconMapper;
import it.unisalento.server.exception.UserAlreadyExistException;
import it.unisalento.server.exception.UserNotFoundException;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/attachment")
public class AttachmentRestController {

    @Autowired
    IAttachmentService attachmentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttachmentDTO save(@RequestBody AttachmentDTO attachmentDTO) throws UserAlreadyExistException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.save(AttachmentMapper.makeAttachment(attachmentDTO)));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttachmentDTO delete(@PathVariable int id) throws UserNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.delete(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<AttachmentDTO> getAll(){
        return AttachmentMapper.makeAttachmentDTOList(attachmentService.getAll());
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public AttachmentDTO getById(@PathVariable int id) throws UserNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.getById(id));
    }
}
