package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.QuestionDto;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.service.abstraction.ClientCommunicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    private ClientCommunicationService clientCommunicationService;

    public SurveyController(ClientCommunicationService clientCommunicationService) {
        this.clientCommunicationService = clientCommunicationService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getQuestions(){
        List<Survey> questions= clientCommunicationService.getOrderedQuestions();
        return ResponseEntity.ok().body(questions.stream().map(QuestionDto::new).toList());
    }

}
