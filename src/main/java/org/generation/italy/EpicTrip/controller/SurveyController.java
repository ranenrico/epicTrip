package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.QuestionDto;
import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.dto.SurveyInfoDto;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.model.service.abstraction.ClientCommunicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    //TO-DO
    @PostMapping
    public ResponseEntity<SurveyAnswerDto> saveSurveyAnswer(@RequestBody List<SurveyAnswerDto> answers){
        return null;
    }

}
