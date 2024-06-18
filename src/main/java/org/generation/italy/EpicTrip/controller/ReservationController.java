package org.generation.italy.EpicTrip.controller;
import org.generation.italy.EpicTrip.dto.GuideDto;
import org.generation.italy.EpicTrip.dto.HolidayPackageDto;
import org.generation.italy.EpicTrip.dto.HotelDto;
import org.generation.italy.EpicTrip.dto.RestaurantDto;
import org.generation.italy.EpicTrip.model.*;
import org.generation.italy.EpicTrip.model.service.abstraction.GuideService;
import org.generation.italy.EpicTrip.model.service.abstraction.HotelService;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/holiday-reservation")
public class ReservationController {

    public ReservationController() {
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@AuthenticationPrincipal UserPrincipal principal){
        System.out.println(principal.getUsername());
        System.out.println(principal.getUser().getId());
        return ResponseEntity.ok().build();
    }
}
