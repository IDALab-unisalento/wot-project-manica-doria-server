package it.unisalento.server.DTO;

import it.unisalento.server.entities.Maintenance;
import it.unisalento.server.entities.Message;
import it.unisalento.server.entities.User;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

public class ChatDTO {

    private int id;
    private MaintenanceDTO maintenance;
    private  List<MessageDTO> message;

    public ChatDTO(int id, MaintenanceDTO maintenance,  List<MessageDTO> message) {
        this.id = id;
        this.maintenance = maintenance;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public MaintenanceDTO getMaintenance() {
        return maintenance;
    }

    public  List<MessageDTO> getMessage() {
        return message;
    }

    public static class ChatDTOBuilder {
        private int id;
        private MaintenanceDTO maintenance;
        private List<MessageDTO> message;


        public ChatDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ChatDTOBuilder setMaintenance(MaintenanceDTO maintenance) {
            this.maintenance = maintenance;
            return this;
        }

        public ChatDTOBuilder setMessage(List<MessageDTO> message) {
            this.message = message;
            return this;
        }

        public ChatDTO build() {
            return new ChatDTO(id, maintenance, message);
        }
    }
}
