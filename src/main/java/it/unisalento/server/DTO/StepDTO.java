package it.unisalento.server.DTO;

import it.unisalento.server.entities.Attachment;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.Zone;
import java.util.List;

public class StepDTO {

    int id;
    String name;
    String description;
    List<Attachment> attachmentList;
    Maintenance maintenance;
    Zone zone;

    public StepDTO() {
    }

    public StepDTO(int id, String name, String description, List<Attachment> attachmentList, Maintenance maintenance, Zone zone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attachmentList = attachmentList;
        this.maintenance = maintenance;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public static StepDTO cvtStepDTO(Step step) {
        StepDTO stepDTO = new StepDTO();
        stepDTO.setId(step.getId());
        stepDTO.setName(step.getName());
        stepDTO.setDescription(step.getDescription());
        stepDTO.setMaintenance(step.getMaintenance());
        stepDTO.setAttachmentList(step.getAttachmentList());
        stepDTO.setZone(step.getZone());
        return stepDTO;
    }
}
