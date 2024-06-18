package org.generation.italy.EpicTrip.model.service.implementation;
import org.generation.italy.EpicTrip.model.Guide;
import org.generation.italy.EpicTrip.model.repository.abstraction.GuideRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.GuideService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaGuideService implements GuideService {
    GuideRepository guideRepository;

    public JpaGuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }


    @Override
    public Optional<Guide> findGuideByCity(String city) {
      return  guideRepository.findByCity(city);
    }
}

