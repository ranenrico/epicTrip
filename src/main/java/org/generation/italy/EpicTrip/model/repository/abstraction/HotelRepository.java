package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.Guide;
import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    @Query("""
    SELECT h FROM Hotel h WHERE h.city =(
        SELECT p.city FROM HolidayPackage p WHERE p.id= :id)
         and  h.priceRange=(
         SELECT p.priceRange FROM HolidayPackage p where p.id= :id)
         ORDER BY FUNCTION('RANDOM') LIMIT 1
    """)
    Optional<Hotel> findHotelByPackage(long id);
}
