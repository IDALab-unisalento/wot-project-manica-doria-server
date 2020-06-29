package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Maintenance maintenance;

    public UserMaintenance() {
    }

    public UserMaintenance(int id, Date date, String status, User user, Maintenance maintenance) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.user = user;
        this.maintenance = maintenance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }
}
