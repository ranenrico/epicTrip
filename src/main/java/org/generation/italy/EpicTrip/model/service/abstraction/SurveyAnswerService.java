package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SurveyAnswerService {
  List<SurveyAnswer> saveSurveyAnswers(List<SurveyAnswer> surveyAnswers);

  Survey getQuestionById(Long questionId) throws EntityNotFoundException;
}
