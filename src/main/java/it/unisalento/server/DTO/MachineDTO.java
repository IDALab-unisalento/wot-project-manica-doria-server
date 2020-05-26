package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Zone;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MachineDTO {

    private int id;
    private String name;
    private String serialNumber;

    private List<ZoneDTO> zoneList;

    public MachineDTO() { }

    public MachineDTO(int id, String name, String serialNumber, List<ZoneDTO> zoneList) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.zoneList = zoneList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public List<ZoneDTO> getZoneList() {
        return zoneList;
    }

    public static class MachineDTOBuilder {
        private int id;
        private String name;
        private String serialNumber;

        private List<ZoneDTO> zoneList;

        public MachineDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MachineDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MachineDTOBuilder setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public MachineDTOBuilder setZoneList(List<ZoneDTO> zoneList) {
            this.zoneList = zoneList;
            return this;
        }

        public MachineDTO build() {
            return new MachineDTO(id, name, serialNumber, zoneList);
        }
    }
}
