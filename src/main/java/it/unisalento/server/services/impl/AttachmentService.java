package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Attachment;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.AttachmentRepository;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService implements IAttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    @Transactional
    public Attachment save(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    @Transactional
    public Attachment delete(int id) throws ObjectNotFoundException {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if(attachment.isPresent()) {
            attachmentRepository.delete(attachment.get());
            return attachment.get();
        }
        else
            throw new ObjectNotFoundException("Attachment does not found");
    }

    @Override
    @Transactional
    public List<Attachment> getAll() {
        return attachmentRepository.findAll();
    }

    @Override
    @Transactional
    public Attachment getById(int id) throws ObjectNotFoundException {
        return attachmentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Attachment with id='"+id+"' Not Found"));
    }
}
