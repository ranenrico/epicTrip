package org.generation.italy.EpicTrip.model.service.abstraction;

import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.dto.SurveyInfoDto;

import java.util.List;
import java.util.Optional;

public interface HolidayPackageService {
    Optional<HolidayPackage> find(SurveyInfoDto info);

    List<HolidayPackage> findPackageByCity(String city);

    List<String> getCities();

    List<String> getPackageTypes();
}
