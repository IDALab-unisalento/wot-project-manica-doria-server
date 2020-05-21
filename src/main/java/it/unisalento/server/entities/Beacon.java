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

    public Beacon() { }

    public Beacon(int id, String name, String mac) {
        this.id = id;
        this.name = name;
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public Beacon setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Beacon setName(String name) {
        this.name = name;
        return this;
    }

    public String getMac() {
        return mac;
    }

    public Beacon setMac(String mac) {
        this.mac = mac;
        return this;
    }

    public Zone getZone() {
        return zone;
    }

    public Beacon setZone(Zone zone) {
        this.zone = zone;
        return this;
    }
}