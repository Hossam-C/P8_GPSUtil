package com.P8.GPS.Controller;


import com.P8.GPS.DTO.AttractionDTO;
import com.P8.GPS.DTO.VisitedLocationDTO;
import com.P8.GPS.Exceptions.UserIdException;
import com.P8.GPS.Service.GPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GPSController {

    @Autowired
    GPSService gpsService;

    @GetMapping("/")
    public String gpsHome() {
        return  "P8 gpsHome";
    }

    @GetMapping("/gpsattractions")
    public List<AttractionDTO> gpsGetAttractions() {
        return gpsService.getAttractions();
    }
    @GetMapping("/gpsuserlocation")
    public VisitedLocationDTO gpsGetUserLocation(@RequestParam String userId) throws UserIdException {
        if (userId.isEmpty()) {
            throw new UserIdException("The userId is mandatory");
        }
        VisitedLocationDTO visitedLocationDTO = gpsService.getUserLocation(UUID.fromString(userId));
        return visitedLocationDTO;
    }


}
