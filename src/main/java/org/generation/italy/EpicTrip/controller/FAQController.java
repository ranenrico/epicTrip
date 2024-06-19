package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.FAQDto;
import org.generation.italy.EpicTrip.model.FAQ;
import org.generation.italy.EpicTrip.model.service.abstraction.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/faq")
public class FAQController {
    private FAQService faqService;

    @Autowired
    public FAQController(FAQService faqService) {
        this.faqService = faqService;
    }

    @GetMapping
     public List<FAQDto> getAllFaq() {
        return this.faqService.findAllFaq().stream().map(faq -> {
            FAQDto faqDto = new FAQDto();
            faqDto.setId(faq.getId());
            faqDto.setQuestion(faq.getQuestion());
            faqDto.setAnswer(faq.getAnswer());
            return faqDto;
        }).collect(Collectors.toList());
    }
}
