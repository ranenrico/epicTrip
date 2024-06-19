package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class SurveyAnswerDto {
    private long id;
    private String answer;
    private String answerDate;
    private Long questionId;
    private Long userId;

    public SurveyAnswerDto(SurveyAnswer sa) {
        this.id = sa.getId();
        this.answer = sa.getAnswer();
        this.answerDate = DateUtils.format(sa.getAnswerDate());
        this.questionId = sa.getQuestion().getId();
        this.userId = sa.getUser().getId();

    }

    public SurveyAnswerDto() {
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

    public Long getQuestionId() {
        return questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswerDate(String answerDate) {
        this.answerDate = answerDate;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SurveyAnswer toSurveyAnswer(AppUser user, Survey survey){
        return new SurveyAnswer(this.id, this.answer, DateUtils.parse(this.answerDate), survey, user);
    }
}
