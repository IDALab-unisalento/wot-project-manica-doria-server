package it.unisalento.server.DTO;

public class BeaconDTO {

    int id;
    String name;
    String mac;
    ZoneDTO zoneDTO;

    public BeaconDTO() {
    }

    public BeaconDTO(int id, String name, String mac, ZoneDTO zoneDTO) {
        this.id = id;
        this.name = name;
        this.mac = mac;
        this.zoneDTO = zoneDTO;
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

    public ZoneDTO getZoneDTO() {
        return zoneDTO;
    }

    public static class BeaconDTOBuilder {
        int id;
        String name;
        String mac;
        ZoneDTO zoneDTO;

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

        public BeaconDTOBuilder setZoneDTO(ZoneDTO zoneDTO) {
            this.zoneDTO = zoneDTO;
            return this;
        }

        public BeaconDTO build() {
            return new BeaconDTO(id, name, mac, zoneDTO);
        }
    }
}
