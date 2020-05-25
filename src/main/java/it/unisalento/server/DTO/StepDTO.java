package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.unisalento.server.entities.Maintenance;

import java.util.List;

public class StepDTO {

    private int id;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;

    private List<AttachmentDTO> attachmentList;

    @JsonIgnore
    private MaintenanceDTO maintenance;

    @JsonIgnore
    private ZoneDTO zone;

    public StepDTO() {
    }

    public StepDTO(int id, String name, String description, double duration, double estimateDuration, List<AttachmentDTO> attachmentList, MaintenanceDTO maintenance, ZoneDTO zone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.attachmentList = attachmentList;
        this.maintenance = maintenance;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getDuration() {
        return duration;
    }

    public double getEstimateDuration() {
        return estimateDuration;
    }

    public MaintenanceDTO getMaintenance() {
        return maintenance;
    }

    public ZoneDTO getZone() {
        return zone;
    }

    public List<AttachmentDTO> getAttachmentList() {
        return attachmentList;
    }

    public static class StepDTOBuilder {
        private int id;
        private String name;
        private String description;
        private double duration;
        private double estimateDuration;
        private MaintenanceDTO maintenance;
        private ZoneDTO zone;
        private List<AttachmentDTO> attachmentList;

        public StepDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StepDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StepDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public StepDTOBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public StepDTOBuilder setEstimateDuration(double estimateDuration) {
            this.estimateDuration = estimateDuration;
            return this;
        }

        public StepDTOBuilder setAttachmentList(List<AttachmentDTO> attachmentList) {
            this.attachmentList = attachmentList;
            return this;
        }

        public StepDTOBuilder setMaintenance(MaintenanceDTO maintenance) {
            this.maintenance = maintenance;
            return this;
        }

        public StepDTOBuilder setZone(ZoneDTO zone) {
            this.zone = zone;
            return this;
        }

        public StepDTO build() {
            return new StepDTO(id, name, description, duration, estimateDuration, attachmentList, maintenance, zone);
        }
    }

}
