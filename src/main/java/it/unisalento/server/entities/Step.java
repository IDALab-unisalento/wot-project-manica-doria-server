package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String description;

    @OneToMany(mappedBy = "step")
    List<Attachment> attachmentList;

    @ManyToOne
    Maintenance maintenance;

    @ManyToOne
    Zone zone;

    public Step() {
    }

    public Step(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public List<it.unisalento.server.entities.Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<it.unisalento.server.entities.Attachment> attachmentList) {
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
}
