package org.generation.italy.EpicTrip.model.repository.abstraction;

import org.generation.italy.EpicTrip.model.HolidayPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayPackageRepository extends JpaRepository<HolidayPackage,Long> {
//    HolidayPackage findByCityAndPackageDurationAndPriceRangeAndPackageTypeAndMaxPeopleCountGreaterThanEqual(
//            String city,int packageDuration, String priceRange, String packageType, int numPeople);
    @Query("""
    select h from HolidayPackage h where h.active= true and h.city= :city and h.packageDuration= :packageDuration
    and h.priceRange= :priceRange and h.packageType= :packageType and h.maxPeopleCount >= :numPeople
    """)
    Optional<HolidayPackage> findBySurveyInfo(String city, int packageDuration, String priceRange, String packageType, int numPeople);

    List<HolidayPackage> findByCityAndActiveTrue(String city);

    @Query("select distinct h.city from HolidayPackage h")
    List<String> getHolidayCities();

    @Query("select distinct h.packageType from HolidayPackage h")
    List<String> getHolidayPackageTypes();
}
