package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "survey_answer")
public class SurveyAnswer {

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

    public SurveyAnswer() {
    }

    public SurveyAnswer(long id, String answer, LocalDate answerDate, Survey question, AppUser user) {
        this.id = id;
        this.answer = answer;
        this.answerDate = answerDate;
        this.question = question;
        this.user = user;
    }

    public SurveyAnswer(String answer, Survey question, AppUser user) {
        this.answer = answer;
        this.question = question;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDate getAnswerDate() {
        return answerDate;
    }

    public Survey getQuestion() {
        return question;
    }

    public AppUser getUser() {
        return user;
    }
}
