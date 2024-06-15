package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.model.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientCommunicationService {
    List<String> getSurveyQuestions();
    List<Survey> getOrderedQuestions();
}
