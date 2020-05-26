package it.unisalento.server.services.impl;

import it.unisalento.server.entities.Attachment;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.Zone;
import it.unisalento.server.exception.ObjectNotFoundException;
import it.unisalento.server.repositories.AttachmentRepository;
import it.unisalento.server.repositories.StepRepository;
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

    @Autowired
    StepRepository stepRepository;

    @Override
    @Transactional
    public Attachment save(Attachment attachment) throws ObjectNotFoundException {

        Optional<Step> step = stepRepository.findById(attachment.getStep().getId());

        if (step.isPresent()) {
            attachment.setStep(step.get());
            return attachmentRepository.save(attachment);
        }
        else {
            throw new ObjectNotFoundException("Child Object not Found");
        }
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
