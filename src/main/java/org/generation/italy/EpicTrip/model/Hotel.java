package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    public Hotel() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 32)
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

    @Column(name = "email", length = 32)
    private String email;

    @Column(name = "tripadvisor_rating", nullable = false)
    private double tripadvisorRating;

    @Column(name = "price_range", nullable = false)
    private String priceRange;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @Column(name = "commission", nullable = false)
    private BigDecimal commission;

}
