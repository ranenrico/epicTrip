package org.generation.italy.EpicTrip.controller;
import org.generation.italy.EpicTrip.dto.*;
import org.generation.italy.EpicTrip.model.*;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.service.abstraction.GuideService;
import org.generation.italy.EpicTrip.model.service.abstraction.HotelService;
import org.generation.italy.EpicTrip.model.service.abstraction.ReservationService;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/holiday-reservation")
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody ReservationDto reservationDto,
                                               @AuthenticationPrincipal UserPrincipal principal){
        try {
            ReservationDto result = reservationService.reservePackage(reservationDto, principal.getUser());
            return ResponseEntity.ok(result);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
