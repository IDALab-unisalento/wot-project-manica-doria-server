package it.unisalento.server.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class ZoneDTO {

    private int id;
    private String name;

    private BeaconDTO beacon;
    private List<StepDTO> stepList;

    @JsonIgnore
    private MachineDTO machine;


    public ZoneDTO() {
    }

    public ZoneDTO(int id, String name, BeaconDTO beacon, List<StepDTO> stepList, MachineDTO machine) {
        this.id = id;
        this.name = name;
        this.beacon = beacon;
        this.stepList = stepList;
        this.machine = machine;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BeaconDTO getBeacon() {
        return beacon;
    }

    public List<StepDTO> getStepList() {
        return stepList;
    }

    public MachineDTO getMachine() {
        return machine;
    }

    public static class ZoneDTOBuilder {
        int id;
        String name;

        private BeaconDTO beacon;
        private List<StepDTO> stepList;

        private MachineDTO machine;

        public ZoneDTOBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ZoneDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ZoneDTOBuilder setBeacon(BeaconDTO beacon) {
            this.beacon = beacon;
            return this;
        }

        public ZoneDTOBuilder setStepList(List<StepDTO> stepList) {
            this.stepList = stepList;
            return this;
        }

        public ZoneDTOBuilder setMachine(MachineDTO machine) {
            this.machine = machine;
            return this;
        }

        public ZoneDTO build() {
            return new ZoneDTO(id, name, beacon, stepList, machine);
        }
    }
}
