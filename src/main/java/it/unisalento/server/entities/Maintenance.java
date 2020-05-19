package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String status;
    Date date;

    @OneToOne
    Machine machine;

    @ManyToOne
    User user;

    @OneToMany(mappedBy = "maintenance")
    List<Step> stepList;

    public Maintenance() {
    }

    public Maintenance(int id, String status, Date date, Machine machine, User user) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.machine = machine;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
