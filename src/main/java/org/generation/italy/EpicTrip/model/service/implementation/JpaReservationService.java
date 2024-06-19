package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.ReservationDto;
import org.generation.italy.EpicTrip.dto.RestaurantCheckInDto;
import org.generation.italy.EpicTrip.model.*;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.repository.abstraction.*;
import org.generation.italy.EpicTrip.model.service.abstraction.ReservationService;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaReservationService implements ReservationService {
    private HolidayPackageRepository holidayPackageRepository;
    private GuideRepository guideRepository;
    private HotelRepository hotelRepository;
    private RestaurantRepository restaurantRepository;
    private RestaurantService restaurantService;
    private HolidayPackageReservationRepository holidayPackageReservationRepository;

    @Autowired
    public JpaReservationService(GuideRepository guideRepository, HotelRepository hotelRepository,
                                 RestaurantRepository restaurantRepository, RestaurantService restaurantService,
                                 HolidayPackageReservationRepository holidayPackageReservationRepository,
                                 HolidayPackageRepository holidayPackageRepository){
        this.guideRepository = guideRepository;
        this.hotelRepository = hotelRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
        this.holidayPackageReservationRepository = holidayPackageReservationRepository;
        this.holidayPackageRepository = holidayPackageRepository;
    }

    @Override
    @Transactional
    public ReservationDto reservePackage(ReservationDto reservationDto, AppUser user) throws EntityNotFoundException {
        Optional<HolidayPackage> optionalHolidayPackage = holidayPackageRepository.findById(reservationDto.getPackageId());
        if(optionalHolidayPackage.isEmpty()){
            throw new EntityNotFoundException(HolidayPackage.class, reservationDto.getPackageId());
        }
        HolidayPackage holidayPackage = optionalHolidayPackage.get();
        HolidayPackageReservation holidayPackageReservation = reservationDto.toHolidayPackageReservation(user, holidayPackage);
        Optional<Guide> optionalGuide = guideRepository.findById(reservationDto.getGuideId());
        if(optionalGuide.isEmpty()){
            throw new EntityNotFoundException(Guide.class, reservationDto.getGuideId());
        }
        Guide guide = optionalGuide.get();
        GuideReservation guideReservation = reservationDto.toGuideReservation(guide, holidayPackageReservation);
        holidayPackageReservation.addGuideReservation(guideReservation);
        Optional<Hotel> optionalHotel = hotelRepository.findById(reservationDto.getHotelId());
        if(optionalHotel.isEmpty()){
            throw new EntityNotFoundException(Hotel.class, reservationDto.getHotelId());
        }
        Hotel hotel = optionalHotel.get();
        int numDays = holidayPackageReservation.getHolidayPackage().getPackageDuration();
        LocalDateTime checkout = holidayPackageReservation.getStartDate().plusDays(numDays).atTime(9,30);
        HotelReservation hotelReservation = reservationDto.toHotelReservation(hotel, checkout, holidayPackageReservation);
        holidayPackageReservation.addHotelReservation(hotelReservation);
        //List<Restaurant> restaurants = restaurantService.findRestaurantsForPackage(reservationDto.getPackageId());
        List<Restaurant> restaurants = new ArrayList<>();
        for(RestaurantCheckInDto resDto : reservationDto.getRestaurantCheckIns()){
            Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(resDto.getRestaurantId());
            if(optionalRestaurant.isEmpty()){
                throw new EntityNotFoundException(Restaurant.class, resDto.getRestaurantId());
            }
            restaurants.add(optionalRestaurant.get());
        }
        System.out.println("NUMERO RISTORANTI: " + restaurants.size());
        List<RestaurantReservation> restaurantReservations = reservationDto.toRestaurantReservation(restaurants, holidayPackageReservation);
        holidayPackageReservation.addRestaurantReservations(restaurantReservations);
        HolidayPackageReservation saved = holidayPackageReservationRepository.save(holidayPackageReservation);
        return new ReservationDto(saved, guideReservation, hotelReservation, restaurantReservations);
    }
}
