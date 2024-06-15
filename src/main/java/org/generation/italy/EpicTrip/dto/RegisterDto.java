package org.generation.italy.EpicTrip.dto;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.utils.DateUtils;

import java.time.LocalDate;

public class RegisterDto {
    private AppUserDto userDto;
    private String password;

    public RegisterDto(AppUserDto userDto, String password) {
        this.userDto = userDto;
        this.password = password;
    }
    public AppUser getUserDto() {
        LocalDate birthdate = DateUtils.parse(userDto.getBirthdate());
        return new AppUser(userDto.getId(), userDto.getFirstname(), userDto.getLastname(), birthdate, userDto.getTelephoneNumber(), userDto.getCountry(), userDto.getCity(), userDto.getStreet(), userDto.getHouseNumber(), userDto.getPostalCode(), userDto.getEmail(), userDto.getGender(), password);
    }
}
