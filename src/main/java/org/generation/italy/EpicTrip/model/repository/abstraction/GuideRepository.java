package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GuideRepository extends JpaRepository<Guide,Long> {
    @Query("SELECT g FROM Guide g WHERE g.workplace = :city ORDER BY FUNCTION('RANDOM') LIMIT 1")

    Optional<Guide> findByCity(String city);
}
