package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.AppUserDto;
import org.generation.italy.EpicTrip.dto.LoginInfo;
import org.generation.italy.EpicTrip.dto.RegisterDto;
import org.generation.italy.EpicTrip.dto.TokenResponseDto;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.service.implementation.JwtService;
import org.generation.italy.EpicTrip.model.service.implementation.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        AppUser user = registerUserDto.toUser();
        AppUser userSaved = service.saveUser(user);
        AppUserDto userDto = new AppUserDto(userSaved);
        return new RegisterDto(userDto, user.getPassword());
    }
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto>  login(@RequestBody LoginInfo info){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(info.getEmail(), info.getPassword()));
        var builder=TokenResponseDto.builder();
        TokenResponseDto dto=null;
        if(authentication.isAuthenticated()) {
            dto= builder.setToken(jwtService.generateToken(info.getEmail())).build();
            return ResponseEntity.ok(dto);
        }
        dto=builder.setErrorMessage("login failed").build();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(dto);
    }

}

