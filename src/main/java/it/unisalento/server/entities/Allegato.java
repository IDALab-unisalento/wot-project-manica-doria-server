package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class Allegato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String path;
    String filename;
    String type;

    @ManyToOne
    Passaggio passaggio;

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

    public Passaggio getPassaggio() {
        return passaggio;
    }

    public void setPassaggio(Passaggio passaggio) {
        this.passaggio = passaggio;
    }
}
