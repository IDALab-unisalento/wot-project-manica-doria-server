package it.unisalento.server.controllers.mapper;

import it.unisalento.server.DTO.ZoneDTO;
import it.unisalento.server.entities.Beacon;
import it.unisalento.server.entities.Machine;
import it.unisalento.server.entities.Zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZoneMapper {

    public static ZoneDTO makeZoneDTO(Zone zone) {

        ZoneDTO.ZoneDTOBuilder zoneDTOBuilder = new ZoneDTO.ZoneDTOBuilder()
                .setId(zone.getId())
                .setName(zone.getName());
        if (zone.getStepList() != null) {
            zoneDTOBuilder.setBeacon(BeaconMapper.makeBeaconDTO(zone.getBeacon()));
        }
        if (zone.getBeacon() != null) {
            zoneDTOBuilder.setStepList(StepMapper.makeStepDTOList(zone.getStepList()));

        }
        return zoneDTOBuilder.build();
    }

    public static Zone makeZone(ZoneDTO zoneDTO) {
        Zone zone = new Zone(
                zoneDTO.getId(),
                zoneDTO.getName()
        );
        if (zoneDTO.getStepList() == null) zone.setStepList(new ArrayList<>());
        else zone.setStepList(StepMapper.makeStepList(zoneDTO.getStepList()));

        if (zoneDTO.getBeacon() == null ) zone.setBeacon(new Beacon());
        else zone.setBeacon(BeaconMapper.makeBeacon(zoneDTO.getBeacon()));

        return zone;

    }

    public static List<ZoneDTO> makeZoneDTOList(List<Zone> zoneList) {
        Iterator<Zone> iter = zoneList.iterator();
        List<ZoneDTO> zoneDTOList = new ArrayList<>();
        while (iter.hasNext()) zoneDTOList.add(makeZoneDTO(iter.next()));
        return zoneDTOList;
    }

    public static List<Zone> makeZoneList(List<ZoneDTO> zoneDTOList) {
        Iterator<ZoneDTO> iter = zoneDTOList.iterator();
        List<Zone> zoneList = new ArrayList<>();
        while (iter.hasNext()) zoneList.add(makeZone(iter.next()));
        return zoneList;
    }
}
