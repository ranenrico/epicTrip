package org.generation.italy.EpicTrip.dto;

import jakarta.persistence.*;
import org.generation.italy.EpicTrip.model.Attraction;
import org.generation.italy.EpicTrip.model.NearbyRestaurant;
import org.generation.italy.EpicTrip.model.Restaurant;

public class RestaurantDto {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private String postalCode;
    private String telephoneNumber;
    private String email;
    private double tripadvisorRating;
    private double latitude;
    private double longitude;
    private Attraction attraction;
    private double distance;

    public RestaurantDto() {
    }

    public RestaurantDto(Restaurant r, NearbyRestaurant n) {
        this.id=r.getId();
        this.name=r.getName();
        this.country=r.getCountry();
        this.city=r.getCity();
        this.street=r.getStreet();
        this.houseNumber=r.getHouseNumber();
        this.postalCode=r.getPostalCode();
        this.telephoneNumber=r.getTelephoneNumber();
        this.email=r.getEmail();
        this.tripadvisorRating=r.getTripadvisorRating();
        this.latitude=r.getLatitude();
        this.longitude=r.getLongitude();
        this.attraction=n.getAttraction();
        this.distance=n.getDistance();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getTripadvisorRating() {
        return tripadvisorRating;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public double getDistance() {
        return distance;
    }
    public Restaurant toRestaurant(){
        return new Restaurant(this.id, this.name, this.country, this.city, this.street,
                 this.houseNumber, this.postalCode, this.telephoneNumber, this.email, this.tripadvisorRating,
                this.latitude, this.longitude);
    }
}
