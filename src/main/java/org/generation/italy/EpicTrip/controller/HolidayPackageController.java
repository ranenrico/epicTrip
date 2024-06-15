package org.generation.italy.EpicTrip.controller;

import org.generation.italy.EpicTrip.dto.HolidayPackageDto;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.dto.SurveyInfoDto;
import org.generation.italy.EpicTrip.model.service.abstraction.HolidayPackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/package")
public class HolidayPackageController {
    private HolidayPackageService holidayService;

    public HolidayPackageController(HolidayPackageService holidayService) {
        this.holidayService = holidayService;
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
        return ohp.map(HolidayPackageDto::new).map(ResponseEntity.ok()::body).orElse(ResponseEntity.ok().build());
        //        if(ohp.isEmpty()){
        //            return ResponseEntity.ok().build();
        //        }
        //        HolidayPackageDto dto= new HolidayPackageDto(ohp.get());
        //        return ResponseEntity.ok().body(dto);
    }
}
