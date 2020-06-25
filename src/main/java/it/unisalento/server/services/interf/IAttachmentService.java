package it.unisalento.server.services.interf;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.entities.Attachment;
import it.unisalento.server.exception.ObjectNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IAttachmentService {

    Attachment save(Attachment attachment) throws ObjectNotFoundException;
    Attachment delete(int id) throws ObjectNotFoundException;

    List<Attachment> getAll();
    Attachment getById(int id) throws ObjectNotFoundException;

    List<Attachment> getFile(int id) throws IOException, ObjectNotFoundException;
    Attachment upload(MultipartFile file, String type, int id_step) throws IOException, ObjectNotFoundException;

}
