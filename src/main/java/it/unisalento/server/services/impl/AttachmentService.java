package it.unisalento.server.services.impl;

import it.unisalento.server.repositories.AttachmentRepository;
import it.unisalento.server.services.interf.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService implements IAttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

}
