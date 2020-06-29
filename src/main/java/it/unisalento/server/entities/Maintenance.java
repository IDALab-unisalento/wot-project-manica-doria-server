package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String type;

    @ManyToOne
    private Machine machine;

    @OneToMany(mappedBy = "maintenance", orphanRemoval = true)
    private List<Step> stepList;

    @OneToMany(mappedBy = "maintenance", orphanRemoval = true)
    private List<UserMaintenance> userMaintenance;

    public Maintenance() { }

    public Maintenance(int id, String name, String description, String type, Machine machine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.machine = machine;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public List<UserMaintenance> getUserMaintenance() {
        return userMaintenance;
    }

    public void setUserMaintenance(List<UserMaintenance> userMaintenance) {
        this.userMaintenance = userMaintenance;
    }
}
