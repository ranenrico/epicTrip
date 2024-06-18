package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.RestaurantDto;
import org.generation.italy.EpicTrip.model.Restaurant;
import org.generation.italy.EpicTrip.model.repository.abstraction.RestaurantRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaRestaurantService implements RestaurantService {
    RestaurantRepository restaurantRepository;

    public JpaRestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> findRestaurantNearByAttraction(long attractionId) {
        return null;
    }
}
