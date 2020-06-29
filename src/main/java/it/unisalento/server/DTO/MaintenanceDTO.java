package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintenanceDTO {

    private int id;
    private String name;
    private String description;
    private String type;

    private MachineDTO machine;

    public MaintenanceDTO() { }

    public MaintenanceDTO(int id, String name, String description, String type, MachineDTO machine) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.machine = machine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public static class MaintenanceDTOBuilder {

        private int id;
        private String name;
        private String description;
        private String type;

        private MachineDTO machine;

        public MaintenanceDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MaintenanceDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MaintenanceDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MaintenanceDTOBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public MaintenanceDTOBuilder setMachine(MachineDTO machine) {
            this.machine = machine;
            return this;
        }

        public MaintenanceDTO build(){
            return new MaintenanceDTO(id, name, description, type, machine);
        }
    }
}
