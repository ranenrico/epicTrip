package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nearby_restaurant")
public class NearbyRestaurant {
    public NearbyRestaurant() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;

    @Column(name = "distance", nullable = false)
    private double distance;

}
