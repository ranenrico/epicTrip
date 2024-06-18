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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/holiday-reservation")
public class ReservationController {
    private RestaurantService restaurantService;
    private HotelService hotelService;
    private GuideService guideService;

    public ReservationController(RestaurantService restaurantService, HotelService hotelService, GuideService guideService) {
        this.restaurantService = restaurantService;
        this.hotelService = hotelService;
        this.guideService = guideService;
    }
    //saranno 3 get 1 guida, 2 ristoranti 3 albergo (che url gli diamo pensando al frontend)
    //cosa prendono in input?
    //nome?
    @GetMapping("/guide")
    public ResponseEntity<GuideDto> findGuideByCity(@RequestParam String city){
       Optional<Guide> guideOpt = guideService.findGuideByCity(city);
        return guideOpt.map(GuideDto::new)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.ok().build());
    }
    @GetMapping("/hotel")
    public ResponseEntity<HotelDto> findHotelByPackage(@RequestParam Long packageId){
        Optional<Hotel> hotelOpt= hotelService.findHotelByPackage(packageId);
        return hotelOpt.map(HotelDto::new)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.ok().build());
    }
//    @GetMapping("/restaurant")
//    public ResponseEntity<RestaurantDto> findRestaurantNearByAttraction(@RequestParam long attractionId){
//        Restaurant restaurant=restaurantService.findRestaurantNearByAttraction(attractionId);
//        return ResponseEntity.ok().body(restaurant);
//    }
}
