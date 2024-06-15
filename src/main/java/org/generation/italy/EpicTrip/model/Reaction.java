package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reaction")
public class Reaction {
    public Reaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

}
