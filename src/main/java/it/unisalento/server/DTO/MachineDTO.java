package it.unisalento.server.DTO;

public class MachineDTO {

    private int id;
    private String name;
    private String serialNumber;

    public MachineDTO() { }

    public MachineDTO(int id, String name, String serialNumber) {
        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
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

    public static class MachineDTOBuilder {
        private int id;
        private String name;
        private String serialNumber;

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

        public MachineDTO build() {
            return new MachineDTO(id, name, serialNumber);
        }
    }
}
