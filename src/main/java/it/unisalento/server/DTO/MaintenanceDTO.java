package it.unisalento.server.DTO;

import java.util.Date;
import java.util.List;

public class MaintenanceDTO {

    private int id;
    private String status;
    private Date date;
    private MachineDTO machine;
    private UserDTO user;

    public MaintenanceDTO(int id, String status, Date date, MachineDTO machine, UserDTO user) {
        this.id = id;
        this.status = status;
        this.date = date;
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
        private MachineDTO machine;
        private UserDTO user;
        private List<StepDTO> stepList;

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
            return new MaintenanceDTO(id, status, date, machine, user);
        }
    }
}
