package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class UserMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Maintenance maintenance;

    public UserMaintenance() {
    }

    public UserMaintenance(int id, User user, Maintenance maintenance) {
        this.id = id;
        this.user = user;
        this.maintenance = maintenance;
    }

    public int getId() {
        return id;
    }

    public UserMaintenance setId(int id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserMaintenance setUser(User user) {
        this.user = user;
        return this;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public UserMaintenance setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
        return this;
    }
}
