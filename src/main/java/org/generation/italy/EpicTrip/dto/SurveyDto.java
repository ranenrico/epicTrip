package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.Survey;

public class SurveyDto {
    private long id;
    private String question;
    public SurveyDto(Survey survey) {
        this.id = survey.getId();
        this.question = survey.getQuestion();
    }
    public SurveyDto(){
    }
    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

}
