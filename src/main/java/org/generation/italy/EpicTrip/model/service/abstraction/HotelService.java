package org.generation.italy.EpicTrip.model.service.abstraction;


import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.Hotel;

import java.util.Optional;

public interface HotelService {
   Optional<Hotel> findHotelByPackage(Long packageId);
}
