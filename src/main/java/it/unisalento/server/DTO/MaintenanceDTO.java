package it.unisalento.server.DTO;

import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Step;
import it.unisalento.server.entities.User;
import java.util.Date;
import java.util.List;

public class MaintenanceDTO {

    int id;
    String status;
    Date date;
    Machine machine;
    User user;
    List<Step> stepList;

    public MaintenanceDTO() {
    }

    public MaintenanceDTO(int id, String status, Date date, Machine machine, User user, List<Step> stepList) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.machine = machine;
        this.user = user;
        this.stepList = stepList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Step> getStepList() {
        return stepList;
    }

    public void setStepList(List<Step> stepList) {
        this.stepList = stepList;
    }

    public static MaintenanceDTO cvtMaintenanceDTO(Maintenance maintenance) {
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();
        maintenanceDTO.setId(maintenance.getId());
        maintenanceDTO.setDate(maintenance.getDate());
        maintenanceDTO.setStatus(maintenance.getStatus());
        maintenanceDTO.setMachine(maintenance.getMachine());
        maintenanceDTO.setStepList(maintenance.getStepList());
        maintenanceDTO.setUser(maintenance.getUser());
        return maintenanceDTO;
    }
}
