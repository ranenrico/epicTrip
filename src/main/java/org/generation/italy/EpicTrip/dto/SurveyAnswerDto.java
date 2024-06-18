package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDate;

public class SurveyAnswerDto {
    private long id;
    private String answer;
    private String answerDate;
    private Survey question;
    private AppUser user;

    public SurveyAnswerDto(SurveyAnswer sa) {
        this.id = sa.getId();
        this.answer = sa.getAnswer();
        this.answerDate = DateUtils.format(sa.getAnswerDate());
        this.question = sa.getQuestion();
        this.user = sa.getUser();
    }

    public long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getAnswerDate() {
        return answerDate;
    }

    public Survey getQuestion() {
        return question;
    }

    public AppUser getUser() {
        return user;
    }

    public SurveyAnswer toSurveyAnswer(SurveyAnswerDto sad){
        return new SurveyAnswer(sad.getId(), sad.getAnswer(), DateUtils.parse(sad.getAnswerDate()),
                sad.getQuestion(), sad.getUser());
    }
}
