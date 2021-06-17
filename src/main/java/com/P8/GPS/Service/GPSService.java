package com.P8.GPS.Service;

import com.P8.GPS.DTO.AttractionDTO;
import com.P8.GPS.DTO.VisitedLocationDTO;

import java.util.List;
import java.util.UUID;

public interface GPSService {


    List<AttractionDTO> getAttractions();

    VisitedLocationDTO getUserLocation(UUID userID);
}
