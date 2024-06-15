package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faq")
public class FAQ {
    public FAQ() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question", nullable = false, length = 256)
    private String question;

    @Column(name = "answer", length = 512)
    private String answer;

}

