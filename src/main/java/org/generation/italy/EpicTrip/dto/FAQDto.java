package org.generation.italy.EpicTrip.dto;


import org.generation.italy.EpicTrip.model.FAQ;

public class FAQDto {
    private long id;
    private String question;
    private String answer;

    public FAQDto() {
    }

    public FAQDto(FAQ faq) {
        this.id = faq.getId();
        this.question = faq.getQuestion();
        this.answer = faq.getAnswer();
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //public FAQ toFAQ(){
      //  return new
    }
//}
