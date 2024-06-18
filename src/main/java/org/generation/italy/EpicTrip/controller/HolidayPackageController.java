package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.*;
import org.generation.italy.EpicTrip.model.Guide;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.Hotel;
import org.generation.italy.EpicTrip.model.Restaurant;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.service.abstraction.GuideService;
import org.generation.italy.EpicTrip.model.service.abstraction.HolidayPackageService;
import org.generation.italy.EpicTrip.model.service.abstraction.HotelService;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/package")
public class HolidayPackageController {
    private HolidayPackageService holidayService;
    private RestaurantService restaurantService;
    private GuideService guideService;
    private HotelService hotelService;

    public HolidayPackageController(HolidayPackageService holidayService, RestaurantService restaurantService, GuideService guideService, HotelService hotelService) {
        this.holidayService = holidayService;
        this.restaurantService = restaurantService;
        this.guideService = guideService;
        this.hotelService = hotelService;
    }
    @GetMapping("/city")
    public ResponseEntity<List<String>> getHolidayCities(){
        List<String> cities = this.holidayService.getCities();
        return ResponseEntity.ok(cities);
    }
    @GetMapping
    public ResponseEntity<List<HolidayPackageDto>> findHolidayByCity(@RequestParam String city){
        List<HolidayPackage> hpl= holidayService.findPackageByCity(city);
        return ResponseEntity.ok().body(hpl.stream().map(HolidayPackageDto::new).toList());
    }
    @GetMapping("/type")
    public ResponseEntity<List<String>> getHolidayPackageTypes() {
        List<String> packageTypes = this.holidayService.getPackageTypes();
        return ResponseEntity.ok(packageTypes);
    }
    @PostMapping
    public ResponseEntity<HolidayPackageDto> findHolidayPackage(@RequestBody SurveyInfoDto si) {
        Optional<HolidayPackage> ohp = holidayService.find(si);
        return ohp.map(HolidayPackageDto::new)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
        //        if(ohp.isEmpty()){
        //            return ResponseEntity.ok().build();
        //        }
        //        HolidayPackageDto dto= new HolidayPackageDto(ohp.get());
        //        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HolidayPackageDto> getPackageById(@PathVariable long id){
        Optional<HolidayPackage> ohp = holidayService.findById(id);
//        if(ohp.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(new HolidayPackageDto(ohp.get()));
        return ohp.map(HolidayPackageDto::new)
                .map(ResponseEntity.ok()::body)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/restaurants")
    public ResponseEntity<List<RestaurantDto>> getRestaurantsByPackage(@PathVariable long id){
        try {
            List<Restaurant> restaurants = restaurantService.findRestaurantsForPackage(id);
            return ResponseEntity.ok(restaurants.stream().map(RestaurantDto::new).toList());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

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
}
