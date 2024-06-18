package org.generation.italy.EpicTrip.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.generation.italy.EpicTrip.model.Hotel;

import java.math.BigDecimal;

public class HotelDto {

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

    public HotelDto(Hotel hotel) {
        this.id=hotel.getId();
        this.name=hotel.getName();
        this.country=hotel.getCountry();
        this.city=hotel.getCity();
        this.street=hotel.getStreet();
        this.houseNumber=hotel.getHouseNumber();
        this.postalCode=hotel.getPostalCode();
        this.telephoneNumber=hotel.getTelephoneNumber();
        this.email=hotel.getEmail();
        this.tripadvisorRating=hotel.getTripadvisorRating();
        this.latitude=hotel.getLatitude();
        this.longitude=hotel.getLongitude();

    }

    public HotelDto() {
    }

    public Hotel toHotel(){
        return new Hotel(this.id,this.name,this.country,this.city,this.street,this.houseNumber,
                this.postalCode,this.telephoneNumber,this.email,this.tripadvisorRating,this.latitude,this.longitude);
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTripadvisorRating(double tripadvisorRating) {
        this.tripadvisorRating = tripadvisorRating;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}


