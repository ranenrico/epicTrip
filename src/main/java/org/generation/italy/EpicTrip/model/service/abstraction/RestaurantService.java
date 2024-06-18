package org.generation.italy.EpicTrip.model.service.abstraction;


import org.generation.italy.EpicTrip.model.Restaurant;

import java.util.Optional;

public interface RestaurantService {
    Optional<Restaurant> findRestaurantNearByAttraction(long attractionId);
}
