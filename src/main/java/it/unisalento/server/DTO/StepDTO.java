package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class StepDTO {

    private int id;
    private int numbered;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;
    private String status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MaintenanceDTO maintenance;
    private List<AttachmentDTO> attachmentList;
    private ZoneDTO zone;

    public StepDTO() {
    }

    public StepDTO(int id, int numbered, String name, String description, double duration, double estimateDuration, String status, List<AttachmentDTO> attachmentList, ZoneDTO zone) {
        this.id = id;
        this.numbered = numbered;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.status = status;
        this.attachmentList = attachmentList;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public int getNumbered() {
        return numbered;
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

    public String getStatus() {
        return status;
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
        private int numbered;
        private String name;
        private String description;
        private double duration;
        private double estimateDuration;
        private String status;

        private MaintenanceDTO maintenance;
        private ZoneDTO zone;
        private List<AttachmentDTO> attachmentList;

        public StepDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StepDTOBuilder setNumbered(int numbered) {
            this.numbered = numbered;
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

        public StepDTOBuilder setStatus(String status) {
            this.status = status;
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
            return new StepDTO(id, numbered, name, description, duration, estimateDuration, status, attachmentList, zone);
        }
    }
}
