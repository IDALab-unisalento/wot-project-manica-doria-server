package it.unisalento.server.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMaintenanceDTO {

    private int id;
    private UserDTO user;
    private MaintenanceDTO maintenance;

    private UserMaintenanceDTO() {
    }

    private UserMaintenanceDTO(int id, UserDTO user, MaintenanceDTO maintenance) {
        this.id = id;
        this.user = user;
        this.maintenance = maintenance;
    }

    public int getId() {
        return id;
    }

    public UserDTO getUser() {
        return user;
    }

    public MaintenanceDTO getMaintenance() {
        return maintenance;
    }

    public static class UserMaintenanceBuilderDTO {
        private int id;
        private UserDTO user;
        private MaintenanceDTO maintenance;

        public UserMaintenanceBuilderDTO setId(int id) {
            this.id = id;
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
            return new UserMaintenanceDTO(id, user, maintenance);
        }
    }
}
