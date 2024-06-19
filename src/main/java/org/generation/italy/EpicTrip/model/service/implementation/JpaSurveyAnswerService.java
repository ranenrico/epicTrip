package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.repository.abstraction.AppUserRepository;
import org.generation.italy.EpicTrip.model.repository.abstraction.SurveyAnswerRepository;
import org.generation.italy.EpicTrip.model.repository.abstraction.SurveyRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.SurveyAnswerService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaSurveyAnswerService implements SurveyAnswerService {
    private SurveyAnswerRepository surveyAnswerRepository;
    private SurveyRepository surveyRepository;

    public JpaSurveyAnswerService(SurveyAnswerRepository surveyAnswerRepository, SurveyRepository surveyRepository) {
        this.surveyAnswerRepository = surveyAnswerRepository;
        this.surveyRepository = surveyRepository;
    }


    @Override
    public List<SurveyAnswer> saveSurveyAnswers(List<SurveyAnswer> surveyAnswers) {
        return surveyAnswerRepository.saveAll(surveyAnswers);
    }

    @Override
    public Survey getQuestionById(Long questionId) throws EntityNotFoundException {
        Optional<Survey> surveyOpt = surveyRepository.findById(questionId);
        if(surveyOpt.isEmpty()){
            throw new EntityNotFoundException(Survey.class, questionId);
        }
        return  surveyOpt.get();
    }
}
