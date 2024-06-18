package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "country", nullable = false, length = 16)
    private String country;

    @Column(name = "city", nullable = false, length = 16)
    private String city;

    @Column(name = "street", nullable = false, length = 64)
    private String street;

    @Column(name = "house_number", nullable = false)
    private int houseNumber;

    @Column(name = "postal_code", nullable = false, length = 16)
    private String postalCode;

    @Column(name = "telephone_number", nullable = false, length = 32)
    private String telephoneNumber;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "price_range", nullable = false)
    private String priceRange;

    @Column(name = "tripadvisor_rating", nullable = false)
    private double tripadvisorRating;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;
    public Restaurant() {
    }

    public Restaurant(long id, String name, String country, String city, String street, int houseNumber,
                      String postalCode, String telephoneNumber, String email, double tripadvisorRating,
                      double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.tripadvisorRating = tripadvisorRating;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
