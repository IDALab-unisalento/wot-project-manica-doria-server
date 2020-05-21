package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String path;
    String filename;
    String type;

    @ManyToOne
    Step step;

    public Attachment() { }

    public Attachment(int id, String path, String filename, String type, Step step) {
        this.id = id;
        this.path = path;
        this.filename = filename;
        this.type = type;
        this.step = step;
    }

    public int getId() {
        return id;
    }

    public Attachment setId(int id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Attachment setPath(String path) {
        this.path = path;
        return this;
    }

    public String getFilename() {
        return filename;
    }

    public Attachment setFilename(String filename) {
        this.filename = filename;
        return this;
    }

    public String getType() {
        return type;
    }

    public Attachment setType(String type) {
        this.type = type;
        return this;
    }

    public Step getStep() {
        return step;
    }

    public Attachment setStep(Step step) {
        this.step = step;
        return this;
    }
}
