package com.P8.GPS.Controller;


import com.P8.GPS.DTO.AttractionDTO;
import com.P8.GPS.DTO.VisitedLocationDTO;
import com.P8.GPS.Exceptions.UserIdException;
import com.P8.GPS.Service.GPSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GPSController {

    private Logger logger = LoggerFactory.getLogger(GPSController.class);

    @Autowired
    GPSService gpsService;

    @GetMapping("/")
    public String gpsHome() {

        logger.info("Controller : gpsHome");

        return  "P8 gpsHome";
    }

    @GetMapping("/gpsattractions")
    public List<AttractionDTO> gpsGetAttractions() {

        logger.info("Controller : gpsattractions");

        return gpsService.getAttractions();
    }


    @GetMapping("/gpsuserlocation")
    public VisitedLocationDTO gpsGetUserLocation(@RequestParam String userId) throws UserIdException {

        logger.info("Controller : gpsuserlocation");

        if (userId.isEmpty()) {
            logger.error("Controller : gpsuserlocation => userId is mandatory");
            throw new UserIdException("The userId is mandatory");
        }
        VisitedLocationDTO visitedLocationDTO = gpsService.getUserLocation(UUID.fromString(userId));
        return visitedLocationDTO;
    }


}
