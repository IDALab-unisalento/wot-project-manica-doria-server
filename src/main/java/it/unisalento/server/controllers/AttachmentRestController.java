package it.unisalento.server.controllers;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.controllers.mapper.AttachmentMapper;
import it.unisalento.server.entities.Attachment;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/attachment")
public class AttachmentRestController {

    @Autowired
    IAttachmentService attachmentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttachmentDTO save(@RequestBody AttachmentDTO attachmentDTO) throws ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.save(AttachmentMapper.makeAttachment(attachmentDTO)));
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

    @RequestMapping(value = "/upload/{type}/{id_step}",  method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public AttachmentDTO uploadWithInfo(@RequestAttribute("file") MultipartFile file, @PathVariable String type, @PathVariable int id_step) throws IOException, ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.upload(file, type, id_step));
    }

    @GetMapping(value = "/getFile/{id}")
    public List<String> getFile(@PathVariable int id) throws IOException, ObjectNotFoundException {
        return attachmentService.getFile(id);
    }

}
