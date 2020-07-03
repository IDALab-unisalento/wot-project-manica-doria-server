package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String encodedFile;
    private String path;
    private String filename;
    private String type;

    @ManyToOne
    private Step step;

    public Attachment() { }

    public Attachment(int id, String encodedFile, String path, String filename, String type, Step step) {
        this.id = id;
        this.encodedFile = encodedFile;
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

    public String getEncodedFile() {
        return encodedFile;
    }

    public void setEncodedFile(String encodedFile) {
        this.encodedFile = encodedFile;
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
}
