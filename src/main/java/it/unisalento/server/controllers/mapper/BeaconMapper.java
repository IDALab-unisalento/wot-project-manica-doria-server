package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.BeaconDTO;
import it.unisalento.server.entities.Beacon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeaconMapper {

    public static BeaconDTO makeBeaconDTO(Beacon beacon) {

        BeaconDTO.BeaconDTOBuilder beaconDTOBuilder = new BeaconDTO.BeaconDTOBuilder()
                .setId(beacon.getId())
                .setName(beacon.getName())
                .setMac(beacon.getMac());
        return beaconDTOBuilder.build();
    }

    public static Beacon makeBaacon(BeaconDTO beaconDTO) {
        return new Beacon(beaconDTO.getId(), beaconDTO.getName(), beaconDTO.getMac());
    }

    public static List<BeaconDTO> makeBeaconDTOList(List<Beacon> beaconList) {
        Iterator<Beacon> iter = beaconList.iterator();
        List<BeaconDTO> beaconDTOList = new ArrayList<>();
        while (iter.hasNext()) beaconDTOList.add(makeBeaconDTO(iter.next()));
        return beaconDTOList;
    }
}
