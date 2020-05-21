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

    public Zone(int id, String name, Machine machine, Beacon beacon) {
        this.id = id;
        this.name = name;
        this.machine = machine;
        this.beacon = beacon;
    }

    public int getId() {
        return id;
    }

    public Zone setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Zone setName(String name) {
        this.name = name;
        return this;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public Zone setStepList(List<Step> stepList) {
        this.stepList = stepList;
        return this;
    }

    public Machine getMachine() {
        return machine;
    }

    public Zone setMachine(Machine machine) {
        this.machine = machine;
        return this;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public Zone setBeacon(Beacon beacon) {
        this.beacon = beacon;
        return this;
    }
}
