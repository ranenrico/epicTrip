package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDate;

public class AppUserDto {
    private long id;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String telephoneNumber;
    private String country;
    private String city;
    private String street;
    private int houseNumber;
    private String postalCode;
    private String email;
    private String gender;

    public AppUserDto(AppUser user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.birthdate = DateUtils.format(user.getBirthdate());
        this.telephoneNumber = user.getTelephoneNumber();
        this.country = user.getCountry();
        this.city = user.getCity();
        this.street = user.getStreet();
        this.houseNumber = user.getHouseNumber();
        this.postalCode = user.getPostalCode();
        this.email = user.getEmail();
        this.gender = user.getGender();
    }

    public AppUserDto() {
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

    public String getBirthdate() {
        return birthdate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
    public AppUser toAppUser() {
        LocalDate birthdate = DateUtils.parse(this.birthdate);
        return new AppUser(this.id, this.firstname, this.lastname, birthdate, this.telephoneNumber, this.country, this.city, this.street, this.houseNumber, this.postalCode, this.email, this.gender);
    }
}
