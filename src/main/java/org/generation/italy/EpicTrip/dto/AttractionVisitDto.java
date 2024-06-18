package org.generation.italy.EpicTrip.dto;

import jakarta.persistence.*;
import org.generation.italy.EpicTrip.model.Attraction;
import org.generation.italy.EpicTrip.model.AttractionVisit;
import org.generation.italy.EpicTrip.model.HolidayPackage;

import java.time.LocalTime;

public class AttractionVisitDto {

    private long id;
    private long attractionId;
    private String attractionName;
    private String attractionDescription;
    private int attractionOrder;
    private int visitDay;
    private String city;
    private long packageId;

    public AttractionVisitDto() {
    }

    public AttractionVisitDto(AttractionVisit av) {
        this.id=av.getId();
        this.attractionId=av.getAttraction().getId();
        this.attractionName=av.getAttraction().getName();
        this.attractionDescription=av.getAttraction().getDescription();
        this.attractionOrder=av.getAttractionOrder();
        this.visitDay=av.getVisitDay();
        this.city=av.getAttraction().getCity();
        this.packageId = av.getHolidayPackage().getId();
    }

    public long getId() {
        return id;
    }

    public long getAttractionId() {
        return attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public String getAttractionDescription() {
        return attractionDescription;
    }

    public int getAttractionOrder() {
        return attractionOrder;
    }

    public int getVisitDay() {
        return visitDay;
    }

    public String getCity() {
        return city;
    }

    public long getPackageId() {
        return packageId;
    }
}
