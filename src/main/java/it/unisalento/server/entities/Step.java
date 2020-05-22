package it.unisalento.server.entities;

import it.unisalento.server.DTO.ZoneDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;

    @OneToMany(mappedBy = "step", orphanRemoval = true)
    private List<Attachment> attachmentList;

    @ManyToOne
    private Maintenance maintenance;

    @ManyToOne
    private Zone zone;

    public Step() {
    }

    public Step(int id, String name, String description, double duration, double estimateDuration, Maintenance maintenance, Zone zone) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.maintenance = maintenance;
        this.zone = zone;
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
