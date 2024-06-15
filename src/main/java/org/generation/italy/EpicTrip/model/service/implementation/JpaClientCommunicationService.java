package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.repository.abstraction.SurveyRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.ClientCommunicationService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class JpaClientCommunicationService implements ClientCommunicationService {

    private final SurveyRepository surveyRepository;

    public JpaClientCommunicationService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<String> getSurveyQuestions() {
        List<Survey> ls = surveyRepository.findAll();
        return ls.stream().sorted(Comparator.comparingLong(Survey::getId))
                .map(Survey::getQuestion).toList();
    }

    @Override
    public List<Survey> getOrderedQuestions() {
        return surveyRepository.findAllByOrderById();
    }
}
