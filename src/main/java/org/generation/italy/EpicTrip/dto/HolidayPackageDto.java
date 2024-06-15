package org.generation.italy.EpicTrip.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.generation.italy.EpicTrip.model.AttractionVisit;
import org.generation.italy.EpicTrip.model.GuideReservation;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.HolidayPackageReservation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HolidayPackageDto {
    private long id;
    private int packageDuration;
    private String packageType;
    private String country;
    private String city;
    private String priceRange;
    private String title;
    private String description;
    private int maxPeopleCount;
    private String imagePath;
    private List<AttractionVisitDto> attractionVisits = new ArrayList<>();

    public HolidayPackageDto() {
    }
    public HolidayPackageDto(HolidayPackage hp) {
        this.id=hp.getId();
        this.packageDuration=hp.getPackageDuration();
        this.packageType=hp.getPackageType();
        this.country=hp.getCountry();
        this.city=hp.getCity();
        this.priceRange=hp.getPriceRange();
        this.title=hp.getTitle();
        this.description=hp.getDescription();
        this.maxPeopleCount=hp.getMaxPeopleCount();
        this.imagePath=hp.getImagePath();
        this.attractionVisits=hp.getAttractionVisits().stream().sorted(Comparator.comparingInt(AttractionVisit::getAttractionOrder)).map(AttractionVisitDto::new).toList();
    }


    public long getId() {
        return id;
    }

    public int getPackageDuration() {
        return packageDuration;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxPeopleCount() {
        return maxPeopleCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<AttractionVisitDto> getAttractionVisits() {
        return attractionVisits;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
