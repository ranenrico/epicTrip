package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.model.SurveyAnswer;

import java.util.List;
import java.util.Optional;

public interface SurveyAnswerService {
    List<SurveyAnswer> saveSurveyAnswer(List<SurveyAnswer> answers);
}
