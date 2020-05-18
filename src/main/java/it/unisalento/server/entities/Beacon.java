package it.unisalento.server.entities;

import javax.persistence.*;

@Entity
public class Beacon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    String mac;

    @OneToOne(mappedBy = "beacon")
    Zone zone;

    public Beacon() {
    }

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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }
}