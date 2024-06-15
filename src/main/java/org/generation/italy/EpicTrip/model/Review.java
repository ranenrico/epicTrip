package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "rating", nullable = false)
    private int rating;

}
