package it.unisalento.server.DTO;

import java.util.List;

public class StepDTO {

    private int id;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;

    private List<AttachmentDTO> attachmentList;

    public StepDTO() {
    }

    public StepDTO(int id, String name, String description, double duration, double estimateDuration, List<AttachmentDTO> attachmentList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.attachmentList = attachmentList;
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

    public List<AttachmentDTO> getAttachmentList() {
        return attachmentList;
    }

    public static class StepDTOBuilder {
        private int id;
        private String name;
        private String description;
        private double duration;
        private double estimateDuration;

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

        public StepDTO build() {
            return new StepDTO(id, name, description, duration, estimateDuration, attachmentList);
        }
    }

}
