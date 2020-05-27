package it.unisalento.server.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ZoneDTO {

    private int id;
    private String name;

    private BeaconDTO beacon;

    //@JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MachineDTO machine;

    public ZoneDTO() {
    }

    public ZoneDTO(int id, String name, BeaconDTO beacon) {
        this.id = id;
        this.name = name;
        this.beacon = beacon;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BeaconDTO getBeacon() {
        return beacon;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public static class ZoneDTOBuilder {
        int id;
        String name;

        private BeaconDTO beacon;

        //@JsonIgnore
        private MachineDTO machine;

        public ZoneDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ZoneDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ZoneDTOBuilder setBeacon(BeaconDTO beacon) {
            this.beacon = beacon;
            return this;
        }


        public ZoneDTOBuilder setMachine(MachineDTO machine) {
            this.machine = machine;
            return this;
        }

        public ZoneDTO build() {
            return new ZoneDTO(id, name, beacon);
        }
    }
}
