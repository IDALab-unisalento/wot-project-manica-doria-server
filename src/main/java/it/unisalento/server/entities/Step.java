package it.unisalento.server.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numbered;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;
    private String status;

    @OneToMany(mappedBy = "step", orphanRemoval = true)
    private List<Attachment> attachmentList;

    @ManyToOne
    private Maintenance maintenance;

    @ManyToOne
    private Zone zone;

    public Step() {
    }

    public Step(int id, int numbered, String name, String description, double duration, double estimateDuration, String status, Maintenance maintenance, Zone zone) {
        this.id = id;
        this.numbered = numbered;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.status = status;
        this.maintenance = maintenance;
        this.zone = zone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumbered() {
        return numbered;
    }

    public void setNumbered(int numbered) {
        this.numbered = numbered;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getEstimateDuration() {
        return estimateDuration;
    }

    public void setEstimateDuration(double estimateDuration) {
        this.estimateDuration = estimateDuration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
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

