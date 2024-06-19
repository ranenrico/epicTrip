package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "package_reservation")
public class HolidayPackageReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private HolidayPackage holidayPackage;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser user;

    @Column(name = "people_count", nullable = false)
    private int peopleCount;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @OneToMany(mappedBy = "holidayPackageReservation", cascade = CascadeType.PERSIST)
    private List<GuideReservation> guideReservations = new ArrayList<>();

    @OneToMany(mappedBy = "holidayPackageReservation", cascade = CascadeType.PERSIST)
    private List<HotelReservation> hotelReservations = new ArrayList<>();

    @OneToMany(mappedBy = "holidayPackageReservation", cascade = CascadeType.PERSIST)
    private List<RestaurantReservation> restaurantReservations = new ArrayList<>();

    public HolidayPackageReservation() {
    }

    public HolidayPackageReservation(HolidayPackage holidayPackage, AppUser user, int peopleCount, BigDecimal cost, LocalDate creationDate, LocalDate startDate) {
        this.holidayPackage = holidayPackage;
        this.user = user;
        this.peopleCount = peopleCount;
        this.cost = cost;
        this.creationDate = creationDate;
        this.startDate = startDate;
    }

    public void addGuideReservation(GuideReservation gr){
        this.guideReservations.add(gr);
    }

    public void addHotelReservation(HotelReservation hr){
        this.hotelReservations.add(hr);
    }

    public void addRestaurantReservation(RestaurantReservation rr){
        this.restaurantReservations.add(rr);
    }

    public void addRestaurantReservations(List<RestaurantReservation> rrs){
        this.restaurantReservations.addAll(rrs);
        System.out.println("in addRestaurantReservations " + this.restaurantReservations.size());
    }

    public long getId() {
        return id;
    }

    public HolidayPackage getHolidayPackage() {
        return holidayPackage;
    }

    public AppUser getUser() {
        return user;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
