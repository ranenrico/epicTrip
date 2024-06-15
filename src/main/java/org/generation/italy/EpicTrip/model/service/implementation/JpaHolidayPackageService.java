package org.generation.italy.EpicTrip.model.service.implementation;

import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.generation.italy.EpicTrip.dto.SurveyInfoDto;
import org.generation.italy.EpicTrip.model.repository.abstraction.HolidayPackageRepository;
import org.generation.italy.EpicTrip.model.service.abstraction.HolidayPackageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaHolidayPackageService implements HolidayPackageService {
    HolidayPackageRepository hpr;

    public JpaHolidayPackageService(HolidayPackageRepository hpr) {
        this.hpr = hpr;
    }

    @Override
    public Optional<HolidayPackage> find(SurveyInfoDto info) {
        return hpr.findBySurveyInfo(
                info.getCity(),info.getPackageDuration(),info.getPriceRange(),info.getPackageType(),info.getNumPeople());
    }

    @Override
    public List<HolidayPackage> findPackageByCity(String city) {
        return hpr.findByCityAndActiveTrue(city);
    }

    @Override
    public List<String> getCities() {
        return hpr.getHolidayCities();
    }

    @Override
    public List<String> getPackageTypes() {
        return hpr.getHolidayPackageTypes();
    }
}
