package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attraction")
public class Attraction {
    public Attraction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "description", nullable = false, length = 128)
    private String description;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "street", nullable = false, length = 32)
    private String street;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @OneToMany(mappedBy = "attraction", cascade = {CascadeType.REMOVE})
    private List<NearbyRestaurant> nearbyRestaurants = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}


