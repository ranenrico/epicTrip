package org.generation.italy.EpicTrip.model.service.abstraction;


import org.generation.italy.EpicTrip.model.Guide;

import java.util.Optional;

public interface GuideService {
    Optional<Guide> findGuideByCity(String city);

}
