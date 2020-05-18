package it.unisalento.server.DTO;

import java.util.List;

public class StepDTO {

    int id;
    String name;
    String description;
    List<AttachmentDTO> attachmentDTOList;
    MaintenanceDTO maintenanceDTO;
    ZoneDTO zoneDTO;

    public StepDTO() {
    }

    public StepDTO(int id, String name, String description, List<AttachmentDTO> attachmentDTOList, MaintenanceDTO maintenanceDTO, ZoneDTO zoneDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attachmentDTOList = attachmentDTOList;
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

    public List<AttachmentDTO> getAttachmentDTOList() {
        return attachmentDTOList;
    }

    public MaintenanceDTO getMaintenanceDTO() {
        return maintenanceDTO;
    }

    public ZoneDTO getZoneDTO() {
        return zoneDTO;
    }

    public static class StepDTOBuilder {
        int id;
        String name;
        String description;
        List<AttachmentDTO> attachmentDTOList;
        MaintenanceDTO maintenanceDTO;
        ZoneDTO zoneDTO;


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

        public StepDTOBuilder setAttachmentDTOList(List<AttachmentDTO> attachmentDTOList) {
            this.attachmentDTOList = attachmentDTOList;
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
            return new StepDTO(id, name, description, attachmentDTOList, maintenanceDTO, zoneDTO);
        }
    }

}
