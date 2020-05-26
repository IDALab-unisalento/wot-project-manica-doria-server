package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import it.unisalento.server.entities.Zone;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeaconDTO {

    private int id;
    private String name;
    private String mac;

    public BeaconDTO() { }

    public BeaconDTO(int id, String name, String mac) {
        this.id = id;
        this.name = name;
        this.mac = mac;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMac() {
        return mac;
    }

    public static class BeaconDTOBuilder {
        private int id;
        private String name;
        private String mac;

        public BeaconDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public BeaconDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BeaconDTOBuilder setMac(String mac) {
            this.mac = mac;
            return this;
        }

        public BeaconDTO build() {
            return new BeaconDTO(id, name, mac);
        }
    }
}
