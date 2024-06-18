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
    public Hotel toHotel(){
        return new Hotel(this.id,this.name,this.country,this.city,this.street,this.houseNumber,
                this.postalCode,this.telephoneNumber,this.email,this.tripadvisorRating,this.latitude,this.longitude);
    }
}


