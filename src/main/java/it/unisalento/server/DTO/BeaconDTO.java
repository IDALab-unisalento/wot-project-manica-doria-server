package it.unisalento.server.DTO;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Zone;

public class BeaconDTO {

    int id;
    String name;
    String mac;
    Zone zone;

    public BeaconDTO() {
    }

    public BeaconDTO(int id, String name, String mac, Zone zone) {
        this.id = id;
        this.name = name;
        this.mac = mac;
        this.zone = zone;
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

    public static BeaconDTO cvtBeaconDTO(Beacon beacon) {
        BeaconDTO beaconDTO = new BeaconDTO();
        beaconDTO.setId(beacon.getId());
        beaconDTO.setMac(beacon.getMac());
        beaconDTO.setName(beacon.getName());
        beaconDTO.setZone(beacon.getZone());
        return beaconDTO;
    }
}
