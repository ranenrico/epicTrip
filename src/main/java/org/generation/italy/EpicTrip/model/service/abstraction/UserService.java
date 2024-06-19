package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.model.AppUser;
import org.generation.italy.EpicTrip.model.exceptions.EntityNotFoundException;

public interface UserService {
    AppUser saveUser(AppUser user);
    AppUser getById(Long userId) throws EntityNotFoundException;
}
