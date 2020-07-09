package it.unisalento.server.controllers;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.controllers.mapper.AttachmentMapper;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;

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
    public List<AttachmentDTO> getFile(@PathVariable int id) throws IOException, ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTOList(attachmentService.getFile(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/saveVideo/{id_step}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public AttachmentDTO saveVideo(@RequestBody AttachmentDTO attachmentDTO, @PathVariable int id_step) throws ObjectNotFoundException {
        return AttachmentMapper.makeAttachmentDTO(attachmentService.saveVideo(AttachmentMapper.makeAttachment(attachmentDTO), id_step));
    }

    /*
    @GetMapping(value = "/video")
    public ResponseEntity<?> downloadFileFromLocal() {
        Path path = Paths.get("/Users/alex59/Downloads/1.mov");
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("video/mp4"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(HttpServletResponse response) throws IOException {
        InputStream inputStream = new FileInputStream(new File("/Users/alex59/Downloads/1.mov")); //load the file
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }
    */

}
