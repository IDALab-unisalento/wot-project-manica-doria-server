package it.unisalento.server.DTO;

import java.util.Date;

public class UserMaintenanceDTO {

    private int id;
    private Date date;
    private String status;
    private UserDTO user;
    private MaintenanceDTO maintenance;

    private UserMaintenanceDTO() {
    }

    public UserMaintenanceDTO(int id, Date date, String status, UserDTO user, MaintenanceDTO maintenance) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.user = user;
        this.maintenance = maintenance;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public UserDTO getUser() {
        return user;
    }

    public MaintenanceDTO getMaintenance() {
        return maintenance;
    }

    public static class UserMaintenanceBuilderDTO {
        private int id;
        private Date date;
        private String status;
        private UserDTO user;
        private MaintenanceDTO maintenance;

        public UserMaintenanceBuilderDTO setId(int id) {
            this.id = id;
            return this;
        }

        public UserMaintenanceBuilderDTO setDate(Date date) {
            this.date = date;
            return this;
        }

        public UserMaintenanceBuilderDTO setStatus(String status) {
            this.status = status;
            return this;
        }

        public UserMaintenanceBuilderDTO setUser(UserDTO user) {
            this.user = user;
            return this;
        }

        public UserMaintenanceBuilderDTO setMaintenance(MaintenanceDTO maintenance) {
            this.maintenance = maintenance;
            return this;
        }

        public UserMaintenanceDTO build() {
            return new UserMaintenanceDTO(id, date, status, user, maintenance);
        }
    }
}
