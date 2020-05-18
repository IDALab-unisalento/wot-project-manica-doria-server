package it.unisalento.server.DTO;

import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.Zone;

import java.util.List;

public class ZoneDTO {

    int id;
    String name;
    List<Step> stepList;
    Machine machine;
    Beacon beacon;

    public ZoneDTO() {
    }

    public ZoneDTO(int id, String name, List<Step> stepList, Machine machine, Beacon beacon) {
        this.id = id;
        this.name = name;
        this.stepList = stepList;
        this.machine = machine;
        this.beacon = beacon;
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

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }

    public static ZoneDTO cvtZoneDTO(Zone zone) {
        ZoneDTO zoneDTO = new ZoneDTO();
        zoneDTO.setId(zone.getId());
        zoneDTO.setName(zone.getName());
        zoneDTO.setBeacon(zone.getBeacon());
        zoneDTO.setMachine(zone.getMachine());
        zoneDTO.setStepList(zone.getStepList());
        return zoneDTO;
    }
}
