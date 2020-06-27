package it.unisalento.server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Beacon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String mac;

    @OneToMany(mappedBy = "beacon", orphanRemoval = true)
    private List<Zone> zoneList;

    public Beacon() { }

    public Beacon(int id, String name, String mac) {
        this.id = id;
        this.name = name;
        this.mac = mac;
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public List<Zone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
    }
}