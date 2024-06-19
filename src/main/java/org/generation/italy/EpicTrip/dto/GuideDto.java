package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.Guide;

public class GuideDto {

        private long id;
        private String firstname;
        private String lastname;
        private String telephoneNumber;
        private String email;
        private String introduction;
        private String workplace;
        private String image;

    public GuideDto() {
    }

    public GuideDto(Guide guide) {
       this.id = guide.getId();
       this.firstname = guide.getFirstname();
       this.lastname = guide.getLastname();
       this.telephoneNumber = guide.getTelephoneNumber();
       this.email = guide.getEmail();
       this.introduction = guide.getIntroduction();
       this.workplace = guide.getWorkplace();
       this.image = guide.getImage();
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
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
        return new Guide(this.id, this.firstname, this.lastname,
                this.telephoneNumber, this.email, this.introduction, this.workplace, this.image);
    }

    public String getImage() {
        return image;
    }
}
