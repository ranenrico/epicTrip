package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.model.repository.abstraction.SurveyAnswerRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.SurveyAnswerService;

import java.util.List;

public class JpaSurveyAnswerService implements SurveyAnswerService {
    private SurveyAnswerRepository surveyAnswerRepository;

    public JpaSurveyAnswerService(SurveyAnswerRepository surveyAnswerRepository) {
        this.surveyAnswerRepository = surveyAnswerRepository;
    }

    @Override
    public List<SurveyAnswer> saveSurveyAnswer(List<SurveyAnswer> answers) {
        return surveyAnswerRepository.saveAll(answers);
    }
}
