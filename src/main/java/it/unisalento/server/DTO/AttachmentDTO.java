package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentDTO {

    private int id;
    private String encodedFile;
    private String path;
    private String filename;
    private String type;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StepDTO step;

    public AttachmentDTO() { }

    public AttachmentDTO(int id, String encodedFile, String path, String filename, String type) {
        this.id = id;
        this.encodedFile = encodedFile;
        this.path = path;
        this.filename = filename;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getEncodedFile() {
        return encodedFile;
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

    public StepDTO getStep() {
        return step;
    }

    public static class AttachmentDTOBuilder {
        private int id;
        private String encodedFile;
        private String path;
        private String filename;
        private String type;

        private StepDTO step;

        public AttachmentDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public AttachmentDTOBuilder setEncodedFile(String encodedFile) {
            this.encodedFile = encodedFile;
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

        public AttachmentDTOBuilder setStep(StepDTO step) {
            this.step = step;
            return this;
        }

        public AttachmentDTO build() {
            return new AttachmentDTO(id, encodedFile, path, filename, type);
        }
    }
}
