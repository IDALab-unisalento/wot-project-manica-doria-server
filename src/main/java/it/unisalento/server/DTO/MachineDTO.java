package it.unisalento.server.DTO;

public class MachineDTO {

    private int id;
    private String name;

    private MachineDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class MachineDTOBuilder {
        private int id;
        private String name;

        public MachineDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MachineDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MachineDTO build() {
            return new MachineDTO(id, name);
        }
    }
}
