package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.AttachmentDTO;
import it.unisalento.server.entities.Attachment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AttachmentMapper {

    public static AttachmentDTO makeAttachmentDTO(Attachment attachment) {

        AttachmentDTO.AttachmentDTOBuilder attachmentDTOBuilder = new AttachmentDTO.AttachmentDTOBuilder()
                .setId(attachment.getId())
                .setFilename(attachment.getFilename())
                .setPath(attachment.getPath())
                .setType(attachment.getType())
                .setStepDTO((StepMapper.makeStepDTO(attachment.getStep())));
        return attachmentDTOBuilder.build();
    }

    public static Attachment makeAttachment(AttachmentDTO attachmentDTO) {
        return new Attachment(
                attachmentDTO.getId(),
                attachmentDTO.getPath(),
                attachmentDTO.getFilename(),
                attachmentDTO.getType(),
                StepMapper.makeStep(attachmentDTO.getStepDTO()));
    }

    public static List<AttachmentDTO> makeAttachmentDTOList(List<Attachment> attachmentList) {
        Iterator<Attachment> iter = attachmentList.iterator();
        List<AttachmentDTO> attachmentDTOList = new ArrayList<>();
        while (iter.hasNext()) attachmentDTOList.add(makeAttachmentDTO(iter.next()));
        return attachmentDTOList;
    }

    public static List<Attachment> makeAttachmentList(List<AttachmentDTO> attachmentDTOList) {
        Iterator<AttachmentDTO> iter = attachmentDTOList.iterator();
        List<Attachment> attachmentList = new ArrayList<>();
        while (iter.hasNext()) attachmentList.add(makeAttachment(iter.next()));
        return attachmentList;
    }
}
