package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.dto.HotelDto;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.Hotel;
import org.generation.italy.EpicTrip.model.repository.abstraction.HotelRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.HotelService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaHotelService implements HotelService {
    HotelRepository hotelRepository;

    public JpaHotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Optional<Hotel> findHotelByPackage(Long packageId) {
        return hotelRepository.findHotelByPackage(packageId);
    }
}
