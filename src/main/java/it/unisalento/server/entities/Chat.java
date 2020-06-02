package it.unisalento.server.entities;

import sun.applet.Main;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    Maintenance maintenance;

    @OneToMany(mappedBy = "chat")
    List<Message> message;

    public Chat() {
    }

    public Chat(int id, Maintenance maintenance, List<Message> message) {
        this.id = id;
        this.maintenance = maintenance;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
