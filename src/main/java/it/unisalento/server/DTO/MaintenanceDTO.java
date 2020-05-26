package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.unisalento.server.entities.Step;

import java.util.Date;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintenanceDTO {

    private int id;
    private String status;
    private Date date;
    private String type;

    private MachineDTO machine;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDTO user;

    public MaintenanceDTO() { }

    public MaintenanceDTO(int id, String status, Date date, String type, MachineDTO machine, UserDTO user) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.type = type;
        this.machine = machine;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public UserDTO getUser() {
        return user;
    }

    public static class MaintenanceDTOBuilder {

        private int id;
        private String status;
        private Date date;
        private String type;
        private MachineDTO machine;
        private UserDTO user;

        public MaintenanceDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public MaintenanceDTOBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public MaintenanceDTOBuilder setDate(Date date) {
            this.date = date;
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

        public MaintenanceDTOBuilder setUser(UserDTO user) {
            this.user = user;
            return this;
        }

        public MaintenanceDTO build(){
            return new MaintenanceDTO(id, status, date, type, machine, user);
        }
    }
}
