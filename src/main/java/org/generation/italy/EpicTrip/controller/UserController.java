package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.AppUserDto;
import org.generation.italy.EpicTrip.dto.RegisterDto;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.service.implementation.JwtService;
import org.generation.italy.EpicTrip.model.service.implementation.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JpaUserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public RegisterDto register(@RequestBody RegisterDto registerUserDto) {
       AppUser user = registerUserDto.getUserDto();
       AppUser userSaved = service.saveUser(user);
       AppUserDto userDto = new AppUserDto(user);
       return new RegisterDto(userDto, user.getPassword());
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDto user){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getEmail());
        else
            return "Login Failed";

    }

}

