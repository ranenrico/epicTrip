package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "survey_answer")
public class SurveyAnswer {
    public SurveyAnswer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "answer", nullable = false, length = 256)
    private String answer;

    @Column(name = "answer_date", nullable = false)
    private LocalDate answerDate;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Survey question;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

}
