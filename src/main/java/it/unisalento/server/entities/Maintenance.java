package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;
    private Date date;
    private String type;

    @OneToOne
    private Machine machine;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "maintenance", orphanRemoval = true)
    private List<Step> stepList;

    public Maintenance() { }

    public Maintenance(int id, String status, Date date, String type, Machine machine, User user) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.type = type;
        this.machine = machine;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Maintenance setId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Maintenance setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Maintenance setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getType() {
        return type;
    }

    public Maintenance setType(String type) {
        this.type = type;
        return this;
    }

    public Machine getMachine() {
        return machine;
    }

    public Maintenance setMachine(Machine machine) {
        this.machine = machine;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Maintenance setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public Maintenance setStepList(List<Step> stepList) {
        this.stepList = stepList;
        return this;
    }
}
