package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.dto.ReservationDto;
import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;

public interface ReservationService {
    ReservationDto reservePackage(ReservationDto reservationDto, AppUser user) throws EntityNotFoundException;
}
