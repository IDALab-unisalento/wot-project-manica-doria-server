package it.unisalento.server.DTO;

import java.util.List;

public class ZoneDTO {

    int id;
    String name;
    MachineDTO machineDTO;
    BeaconDTO beaconDTO;

    public ZoneDTO() {
    }

    public ZoneDTO(int id, String name, MachineDTO machineDTO, BeaconDTO beaconDTO) {
        this.id = id;
        this.name = name;
        this.machineDTO = machineDTO;
        this.beaconDTO = beaconDTO;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public MachineDTO getMachineDTO() {
        return machineDTO;
    }

    public BeaconDTO getBeaconDTO() {
        return beaconDTO;
    }

    public static class ZoneDTOBuilder {
        int id;
        String name;
        MachineDTO machineDTO;
        BeaconDTO beaconDTO;

        public ZoneDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ZoneDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ZoneDTOBuilder setMachineDTO(MachineDTO machineDTO) {
            this.machineDTO = machineDTO;
            return this;
        }

        public ZoneDTOBuilder setBeaconDTO(BeaconDTO beaconDTO) {
            this.beaconDTO = beaconDTO;
            return this;
        }

        public ZoneDTO build() {
            return new ZoneDTO(id, name, machineDTO, beaconDTO);
        }
    }
}
