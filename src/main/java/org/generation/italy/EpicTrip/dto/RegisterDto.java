package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDate;

public class RegisterDto {
    private AppUserDto user;
    private String password;

    public RegisterDto(AppUserDto userDto, String password) {
        this.user = userDto;
        this.password = password;
    }
    public AppUser toUser() {
        LocalDate birthdate = DateUtils.parse(user.getBirthdate());
        return new AppUser(user.getId(), user.getFirstname(), user.getLastname(), birthdate,
                user.getTelephoneNumber(), user.getCountry(), user.getCity(), user.getStreet(),
                user.getHouseNumber(), user.getPostalCode(), user.getEmail(), user.getGender(), password);
    }
    public AppUserDto getUser(){
        return this.user;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail(){
        return user.getEmail();
    }

    public void setUser(AppUserDto user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
