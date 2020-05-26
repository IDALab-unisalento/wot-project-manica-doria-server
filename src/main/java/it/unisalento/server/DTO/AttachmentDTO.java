package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.unisalento.server.entities.Step;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentDTO {

    private int id;
    private String path;
    private String filename;
    private String type;

    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StepDTO step;

    public AttachmentDTO() { }

    public AttachmentDTO(int id, String path, String filename, String type) {
        this.id = id;
        this.path = path;
        this.filename = filename;
        this.type = type;
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

    public StepDTO getStep() {
        return step;
    }

    public static class AttachmentDTOBuilder {
        private int id;
        private String path;
        private String filename;
        private String type;
        //@JsonIgnore
        private StepDTO step;

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

        public AttachmentDTOBuilder setStep(StepDTO step) {
            this.step = step;
            return this;
        }

        public AttachmentDTO build() {
            return new AttachmentDTO(id, path, filename, type);
        }
    }


}
