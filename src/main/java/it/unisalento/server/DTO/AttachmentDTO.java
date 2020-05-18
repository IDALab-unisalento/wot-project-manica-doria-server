package it.unisalento.server.DTO;

import it.unisalento.server.entities.Attachment;
import it.unisalento.server.entities.Step;

public class AttachmentDTO {

    int id;
    String path;
    String filename;
    String type;
    Step step;

    public AttachmentDTO() { }

    public AttachmentDTO(int id, String path, String filename, String type, Step step) {
        this.id = id;
        this.path = path;
        this.filename = filename;
        this.type = type;
        this.step = step;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public static AttachmentDTO cvtAttachmentDTO(Attachment attachment) {
        AttachmentDTO attachmentDTO = new AttachmentDTO();
        attachmentDTO.setId(attachment.getId());
        attachmentDTO.setPath(attachment.getPath());
        attachmentDTO.setFilename(attachment.getFilename());
        attachmentDTO.setType(attachment.getType());
        attachmentDTO.setStep(attachment.getStep());
        return attachmentDTO;
    }
}
