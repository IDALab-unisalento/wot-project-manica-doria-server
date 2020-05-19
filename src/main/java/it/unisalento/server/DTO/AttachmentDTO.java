package it.unisalento.server.DTO;

public class AttachmentDTO {

    private int id;
    private String path;
    private String filename;
    private String type;
    private StepDTO stepDTO;

    public AttachmentDTO() { }

    public AttachmentDTO(int id, String path, String filename, String type, StepDTO stepDTO) {
        this.id = id;
        this.path = path;
        this.filename = filename;
        this.type = type;
        this.stepDTO = stepDTO;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getFilename() {
        return filename;
    }

    public String getType() {
        return type;
    }

    public StepDTO getStepDTO() {
        return stepDTO;
    }

    public static class AttachmentDTOBuilder {
        private int id;
        private String path;
        private String filename;
        private String type;
        private StepDTO stepDTO;

        public AttachmentDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public AttachmentDTOBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public AttachmentDTOBuilder setFilename(String filename) {
            this.filename = filename;
            return this;
        }

        public AttachmentDTOBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public AttachmentDTOBuilder setStepDTO(StepDTO stepDTO) {
            this.stepDTO = stepDTO;
            return this;
        }

        public AttachmentDTO build() {
            return new AttachmentDTO(id, path, filename, type, stepDTO);
        }
    }


}
