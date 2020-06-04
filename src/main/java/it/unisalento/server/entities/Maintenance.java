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
    private String status;
    private Date date;
    private String type;

    @ManyToOne
    private Machine machine;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "maintenance", orphanRemoval = true)
    private List<Step> stepList;

    @OneToMany(mappedBy = "maintenance", orphanRemoval = true)
    private List<UserMaintenance> userMaintenance;

    public Maintenance() { }

    public Maintenance(int id, String name, String description, String status, Date date, String type, Machine machine, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.date = date;
        this.type = type;
        this.machine = machine;
        this.user = user;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
