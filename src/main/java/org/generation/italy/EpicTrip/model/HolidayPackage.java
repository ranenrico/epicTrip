package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "package")
public class HolidayPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "package_duration", nullable = false)
    private int packageDuration;

    @Column(name = "type", nullable = false)
    private String packageType;

    @Column(name = "country", nullable = false, length = 32)
    private String country;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "price_range", nullable = false)
    private String priceRange;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", length = 256)
    private String description;

    @Column(name = "max_people_count", nullable = false)
    private int maxPeopleCount;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany(mappedBy = "holidayPackage", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<AttractionVisit> attractionVisits = new ArrayList<>();

    public HolidayPackage() {
    }

    public HolidayPackage(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getPackageDuration() {
        return packageDuration;
    }

    public String getPackageType() {
        return packageType;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxPeopleCount() {
        return maxPeopleCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public List<AttractionVisit> getAttractionVisits() {
        return attractionVisits;
    }

}
