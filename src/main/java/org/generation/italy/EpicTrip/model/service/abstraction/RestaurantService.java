package org.generation.italy.EpicTrip.model.service.abstraction;


import org.generation.italy.EpicTrip.model.Restaurant;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Optional<Restaurant> findRestaurantNearByAttraction(long attractionId);
    List<Restaurant> findRestaurantsForPackage(long packageId) throws EntityNotFoundException;
}
