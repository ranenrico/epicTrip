package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.RestaurantDto;
import org.generation.italy.EpicTrip.model.AttractionVisit;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.NearbyRestaurant;
import org.generation.italy.EpicTrip.model.Restaurant;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;
import org.generation.italy.EpicTrip.model.repository.abstraction.HolidayPackageRepository;
import org.generation.italy.EpicTrip.model.repository.abstraction.RestaurantRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JpaRestaurantService implements RestaurantService {
    RestaurantRepository restaurantRepository;
    HolidayPackageRepository holidayPackageRepository;

    public JpaRestaurantService(RestaurantRepository restaurantRepository, HolidayPackageRepository holidayPackageRepository) {
        this.restaurantRepository = restaurantRepository;
        this.holidayPackageRepository = holidayPackageRepository;
    }

    @Override
    public Optional<Restaurant> findRestaurantNearByAttraction(long attractionId) {
        return null;
    }

    @Override
    public List<Restaurant> findRestaurantsForPackage(long packageId) throws EntityNotFoundException {
        Optional<HolidayPackage> ohp = this.holidayPackageRepository.findById(packageId);
        if(ohp.isEmpty()){
            throw new EntityNotFoundException(HolidayPackage.class, packageId);
        }
        HolidayPackage hp = ohp.get();
        String priceRange = hp.getPriceRange();
        List<Restaurant> restaurants = new ArrayList<>();
        for(AttractionVisit av : hp.getAttractionVisits()){
            restaurants.addAll(av.getAttraction().getNearbyRestaurants().stream().map(NearbyRestaurant::getRestaurant)
                    .filter(r -> r.getPriceRange().equals(priceRange)).toList());
        }
        return restaurants;
    }
}
