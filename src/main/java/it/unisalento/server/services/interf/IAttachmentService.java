package it.unisalento.server.services.interf;

import it.unisalento.server.entities.Attachment;
import it.unisalento.server.exception.ObjectNotFoundException;

import java.util.List;

public interface IAttachmentService {

    Attachment save(Attachment attachment);
    Attachment delete(int id) throws ObjectNotFoundException;

    List<Attachment> getAll();
    Attachment getById(int id) throws ObjectNotFoundException;

}
