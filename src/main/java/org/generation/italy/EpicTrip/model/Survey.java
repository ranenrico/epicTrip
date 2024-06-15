package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "survey")
public class Survey {
    public Survey() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question", nullable = false, length = 256)
    private String question;

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }
}
