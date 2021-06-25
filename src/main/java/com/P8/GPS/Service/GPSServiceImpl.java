package com.P8.GPS.Service;


import com.P8.GPS.DTO.AttractionDTO;
import com.P8.GPS.DTO.LocationDTO;
import com.P8.GPS.DTO.VisitedLocationDTO;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Repository
public class GPSServiceImpl implements GPSService {

    private final GpsUtil gpsUtil;

    public GPSServiceImpl() {
        Locale.setDefault(Locale.US);
        this.gpsUtil = new GpsUtil();
    }

    @Override
    public List<AttractionDTO> getAttractions(){

        List<Attraction> attractions =  gpsUtil.getAttractions();

        List<AttractionDTO> attractionDTOList = new ArrayList<>();

        for (Attraction attr : attractions) {
            AttractionDTO attractionDTO = new AttractionDTO(attr.attractionName,attr.city,attr.state,attr.attractionId,attr.latitude, attr.longitude);
            attractionDTOList.add(attractionDTO);
        }
        return attractionDTOList;
    }

    @Override
    public VisitedLocationDTO getUserLocation(UUID userID) {

        VisitedLocation visitedLocation = gpsUtil.getUserLocation(userID);
        LocationDTO locationDTO = new LocationDTO(visitedLocation.location.longitude, visitedLocation.location.latitude);
        VisitedLocationDTO visitedLocationDTO = new VisitedLocationDTO(visitedLocation.userId, locationDTO, visitedLocation.timeVisited);
        return visitedLocationDTO;
    }
}
