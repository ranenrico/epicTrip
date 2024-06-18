package org.generation.italy.EpicTrip.dto;

import jakarta.persistence.*;
import org.generation.italy.EpicTrip.model.Guide;

import java.time.LocalDate;

public class GuideDto {

        private long id;
        private String firstName;
        private String lastName;
        private String telephoneNumber;
        private String email;
        private String introduction;
        private String workplace;

    public GuideDto() {
    }

    public GuideDto(Guide guide) {
       this.id=guide.getId();
       this.firstName=guide.getFirstName();
       this.lastName=guide.getLastName();
       this.telephoneNumber=guide.getTelephoneNumber();
       this.email=guide.getEmail();
       this.introduction=guide.getIntroduction();
       this.workplace=guide.getWorkplace();
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getWorkplace() {
        return workplace;
    }
    public Guide toGuide(){
        return new Guide(this.id, this.firstName,this.lastName,this.telephoneNumber,this.email,this.introduction,this.workplace);
    }
}
