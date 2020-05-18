package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @OneToMany(mappedBy = "zone")
    List<Step> stepList;

    @ManyToOne
    Machine machine;

    @OneToOne
    Beacon beacon;

    public Zone() {
    }

    public Zone(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public it.unisalento.server.entities.Machine getMachine() {
        return machine;
    }

    public void setMachine(it.unisalento.server.entities.Machine machine) {
        this.machine = machine;
    }

    public it.unisalento.server.entities.Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(it.unisalento.server.entities.Beacon beacon) {
        this.beacon = beacon;
    }
}
