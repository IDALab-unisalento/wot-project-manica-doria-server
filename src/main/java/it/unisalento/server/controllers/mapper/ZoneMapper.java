package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.ZoneDTO;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZoneMapper {

    public static ZoneDTO makeZoneDTO(Zone zone) {

        ZoneDTO.ZoneDTOBuilder zoneDTOBuilder = new ZoneDTO.ZoneDTOBuilder()
                .setId(zone.getId())
                .setName(zone.getName())
                .setMachineDTO(MachineMapper.makeMachineDTO(zone.getMachine()))
                .setBeaconDTO(BeaconMapper.makeBeaconDTO(zone.getBeacon()));
        return zoneDTOBuilder.build();
    }

    public static Zone makeZone(ZoneDTO zoneDTO) {
        return new Zone(
                zoneDTO.getId(),
                zoneDTO.getName(),
                MachineMapper.makeMachine(zoneDTO.getMachineDTO()),
                BeaconMapper.makeBeacon(zoneDTO.getBeaconDTO())
        );
    }

    public static List<ZoneDTO> makeZoneDTOList(List<Zone> zoneList) {
        Iterator<Zone> iter = zoneList.iterator();
        List<ZoneDTO> zoneDTOList = new ArrayList<>();
        while (iter.hasNext()) zoneDTOList.add(makeZoneDTO(iter.next()));
        return zoneDTOList;
    }
}
