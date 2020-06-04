package it.unisalento.server.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaintenanceDTO {

    private int id;
    private String name;
    private String description;
    private String status;
    private Date date;
    private String type;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserDTO user;
    private MachineDTO machine;
    private List<StepDTO> stepList;

    public MaintenanceDTO() { }

    public MaintenanceDTO(int id, String name, String description, String status, Date date, String type, MachineDTO machine, List<StepDTO> stepList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.date = date;
        this.type = type;
        this.machine = machine;
        this.stepList = stepList;
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

    public List<StepDTO> getStepList() {
        return stepList;
    }

    public static class MaintenanceDTOBuilder {

        private int id;
        private String name;
        private String description;
        private String status;
        private Date date;
        private String type;

        private UserDTO user;
        private MachineDTO machine;
        private List<StepDTO> stepList;

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

        public MaintenanceDTOBuilder setStepList(List<StepDTO> stepList) {
            this.stepList = stepList;
            return this;
        }

        public MaintenanceDTO build(){
            return new MaintenanceDTO(id, name, description, status, date, type, machine, stepList);
        }
    }
}
