package it.unisalento.server.services.impl;

import it.unisalento.server.DTO.AttachmentDTO;
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
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

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

    String UPLOADED_FOLDER = "/Users/alex59/Downloads/";

    private void saveFile(MultipartFile file) throws IOException {
        //salva un file
        byte[] bytes = file.getBytes();
        String filename = generateUID() + file.getOriginalFilename();
        Path path = Paths.get(UPLOADED_FOLDER + filename); //generiamo nome del file
        Files.write(path, bytes);
    }

    //evitare confilitti di nomi nel salvataggio del file
    private String generateUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    @Override
    public List<String> getFile(int id) throws IOException, ObjectNotFoundException {
        List<Attachment> attachmentList = attachmentRepository.findAllByStep_Id(id);
        List<String> encoded = new ArrayList<>();
        if(!(attachmentList.isEmpty())) {
            for(int i = 0; i < attachmentList.size(); i++)
            {
                File file = ResourceUtils.getFile(attachmentList.get(i).getPath());
                byte[] content = (Files.readAllBytes(file.toPath()));
                encoded.add(i , Base64.getEncoder().encodeToString(content));

            }
            return encoded;
        }
        else
            throw new ObjectNotFoundException("Attachment does not found");
    }

    @Override
    public Attachment upload(MultipartFile file, String type, int id_step) throws IOException, ObjectNotFoundException {
        Attachment attachment = new Attachment();
        attachment.setType(type);
        attachment.setFilename(file.getOriginalFilename());
        attachment.setPath(UPLOADED_FOLDER + file.getOriginalFilename());
        Optional<Step> step = stepRepository.findById(id_step);
        if (step.isPresent()) {
            saveFile(file); //salva il file
            attachment.setStep(step.get());
            return attachmentRepository.save(attachment);
        }
        else {
            throw new ObjectNotFoundException("Child Object not Found");
        }
    }
}
