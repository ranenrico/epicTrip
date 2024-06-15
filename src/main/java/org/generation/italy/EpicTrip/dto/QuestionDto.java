package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.Survey;

public class QuestionDto {
    private long id;
    private String question;
    public QuestionDto(Survey survey) {
        this.id = survey.getId();
        this.question = survey.getQuestion();
    }
    public QuestionDto(){
    }
    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

}
