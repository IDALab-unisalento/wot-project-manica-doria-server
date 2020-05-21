package it.unisalento.server.entities;

import javax.crypto.Mac;
import javax.persistence.*;
import java.util.List;

@Entity
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String serialNumber;

    @OneToOne(mappedBy = "machine")
    Maintenance maintenance;

    @OneToMany(mappedBy = "machine")
    List<Zone> zoneList;

    public Machine(){ }

    public Machine(int id, String name, String serialNumber) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public int getId() {
        return id;
    }

    public Machine setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Machine setName(String name) {
        this.name = name;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Machine setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public Machine setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
        return this;
    }

    public List<Zone> getZoneList() {
        return zoneList;
    }

    public Machine setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
        return this;
    }
}
