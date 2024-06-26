package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.QuestionDto;
import org.generation.italy.EpicTrip.dto.SurveyAnswerDto;
import org.generation.italy.EpicTrip.dto.SurveyInfoDto;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.Survey;
import org.generation.italy.EpicTrip.model.SurveyAnswer;
import org.generation.italy.EpicTrip.model.UserPrincipal;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.service.abstraction.ClientCommunicationService;
import org.generation.italy.EpicTrip.model.service.abstraction.SurveyAnswerService;
import org.generation.italy.EpicTrip.model.service.abstraction.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/survey")
public class SurveyController {
    private ClientCommunicationService clientCommunicationService;
    private SurveyAnswerService surveyAnswerService;
    private UserService userService;

    public SurveyController(ClientCommunicationService clientCommunicationService, UserService userService, SurveyAnswerService surveyAnswerService) {
        this.clientCommunicationService = clientCommunicationService;
        this.userService = userService;
        this.surveyAnswerService = surveyAnswerService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getQuestions() {
        List<Survey> questions = clientCommunicationService.getOrderedQuestions();
        return ResponseEntity.ok().body(questions.stream().map(QuestionDto::new).toList());
    }


    //    //TO-DO
//    @PostMapping
//    public ResponseEntity<?> saveSurveyAnswers(@RequestBody List<SurveyAnswerDto> answersDto){
//        try {
//            AppUser user = userService.getById(answersDto.getFirst().getUserId());
//            Survey survey = surveyAnswerService.getQuestionById(answersDto.getFirst().getQuestionId());/////
//            List<SurveyAnswer> answers= surveyAnswerService.saveSurveyAnswers(answersDto.stream()
//                    .map(ad -> ad.toSurveyAnswer(user,survey)).toList());
//            return ResponseEntity.ok().body(answers.stream().map(SurveyAnswerDto::new).toList());
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        }
    @PostMapping
    public ResponseEntity<?> saveSurveyAnswers(@RequestBody List<SurveyAnswerDto> answersDto,
                                               @AuthenticationPrincipal UserPrincipal principal) {
        try {
            AppUser user = principal.getUser();
            List<SurveyAnswer> answers = new ArrayList<>();
            for(var dto : answersDto){
                Survey survey = surveyAnswerService.getQuestionById(dto.getQuestionId());
                SurveyAnswer answer = dto.toSurveyAnswer(user, survey);
                answers.add(answer);
            }
            List<SurveyAnswer> savedAnswers = surveyAnswerService.saveSurveyAnswers(answers);
            List<SurveyAnswerDto> responseDtos = savedAnswers.stream().map(SurveyAnswerDto::new).collect(Collectors.toList());
            return ResponseEntity.ok().body(responseDtos);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Hai inviato risposte per domande con id non esistenti.");
        }
    }
//            List<SurveyAnswer> answers = answersDto.stream().map(ad -> {
//                try {
//                    Survey survey = surveyAnswerService.getQuestionById(ad.getQuestionId());
//                    return ad.toSurveyAnswer(user, survey);
//                } catch (EntityNotFoundException e) {
//                    System.out.println(e.getMessage());
//                    e.printStackTrace();
//                    throw new RuntimeException(e);
//                }
//            }).collect(Collectors.toList());

}


