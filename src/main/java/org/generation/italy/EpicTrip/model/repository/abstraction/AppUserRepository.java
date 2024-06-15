package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);
}
