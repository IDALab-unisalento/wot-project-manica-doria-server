package it.unisalento.server.DTO;

import java.util.List;

public class StepDTO {

    private int id;
    private String name;
    private String description;
    private double duration;
    private double estimateDuration;
    private MaintenanceDTO maintenanceDTO;
    private ZoneDTO zoneDTO;

    public StepDTO() {
    }

    public StepDTO(int id, String name, String description, double duration, double estimateDuration, MaintenanceDTO maintenanceDTO, ZoneDTO zoneDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.estimateDuration = estimateDuration;
        this.maintenanceDTO = maintenanceDTO;
        this.zoneDTO = zoneDTO;
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

    public double getDuration() {
        return duration;
    }

    public double getEstimateDuration() {
        return estimateDuration;
    }

    public MaintenanceDTO getMaintenanceDTO() {
        return maintenanceDTO;
    }

    public ZoneDTO getZoneDTO() {
        return zoneDTO;
    }

    public static class StepDTOBuilder {
        private int id;
        private String name;
        private String description;
        private double duration;
        private double estimateDuration;
        private MaintenanceDTO maintenanceDTO;
        private ZoneDTO zoneDTO;


        public StepDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StepDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StepDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public StepDTOBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public StepDTOBuilder setEstimateDuration(double estimateDuration) {
            this.estimateDuration = estimateDuration;
            return this;
        }

        public StepDTOBuilder setMaintenanceDTO(MaintenanceDTO maintenanceDTO) {
            this.maintenanceDTO = maintenanceDTO;
            return this;
        }

        public StepDTOBuilder setZoneDTO(ZoneDTO zoneDTO) {
            this.zoneDTO = zoneDTO;
            return this;
        }

        public StepDTO build() {
            return new StepDTO(id, name, description, duration, estimateDuration, maintenanceDTO, zoneDTO);
        }
    }

}
