package it.unisalento.server.DTO;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Zone;
import java.util.List;

public class MachineDTO {

    int id;
    String name;
    Maintenance maintenance;
    List<Zone> zoneList;

    public MachineDTO() {
    }

    public MachineDTO(int id, String name, Maintenance maintenance, List<Zone> zoneList) {
        this.id = id;
        this.name = name;
        this.maintenance = maintenance;
        this.zoneList = zoneList;
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

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public List<Zone> getZoneList() {
        return zoneList;
    }

    public void setZoneList(List<Zone> zoneList) {
        this.zoneList = zoneList;
    }

    public static MachineDTO cvtMachineDTO(Machine machine) {
        MachineDTO machineDTO = new MachineDTO();
        machineDTO.setId(machine.getId());
        machineDTO.setName(machine.getName());
        machineDTO.setMaintenance(machine.getMaintenance());
        machineDTO.setZoneList(machine.getZoneList());
        return machineDTO;
    }
}
