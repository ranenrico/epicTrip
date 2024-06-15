package org.generation.italy.EpicTrip.dto;

import java.time.LocalDate;
import org.generation.italy.EpicTrip.utils.DateUtils;

public class SurveyInfoDto {
    private String city;
    private int numPeople;
    private String startDate;////
    private int packageDuration;
    private String packageType;
    private String priceRange;

    public SurveyInfoDto(String city, int numPeople, LocalDate startDate, int packageDuration, String packageType, String priceRange) {
        this.city = city;
        this.numPeople = numPeople;
        this.startDate = DateUtils.format(startDate);
        this.packageDuration = packageDuration;
        this.packageType = packageType;
        this.priceRange = priceRange;
    }

    public SurveyInfoDto() {
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setPackageDuration(int packageDuration) {
        this.packageDuration = packageDuration;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getCity() {
        return city;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public String getStartDate() {
        return startDate;
    }

    public int getPackageDuration() {
        return packageDuration;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getPriceRange() {
        return priceRange;
    }
}
