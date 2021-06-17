package com.P8.GPS.DTO;

import java.util.Date;
import java.util.UUID;

public class VisitedLocationDTO {

    public UUID userId;
    public LocationDTO location;
    public Date timeVisited;

    public VisitedLocationDTO(UUID userId, LocationDTO location, Date timeVisited) {
        this.userId = userId;
        this.location = location;
        this.timeVisited = timeVisited;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public Date getTimeVisited() {
        return timeVisited;
    }

    public void setTimeVisited(Date timeVisited) {
        this.timeVisited = timeVisited;
    }
}
