package org.generation.italy.EpicTrip.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "restaurant_reservation")
public class RestaurantReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "check_in", nullable = false)
    private LocalDateTime checkIn;

    @Column(name = "people_count", nullable = false)
    private int peopleCount;

    @ManyToOne
    @JoinColumn(name = "package_reservation_id", nullable = false)
    private HolidayPackageReservation holidayPackageReservation;

    public RestaurantReservation() {
    }

    public RestaurantReservation(Restaurant restaurant, LocalDate reservationDate, LocalDateTime checkIn, int peopleCount, HolidayPackageReservation holidayPackageReservation) {
        this.restaurant = restaurant;
        this.reservationDate = reservationDate;
        this.checkIn = checkIn;
        this.peopleCount = peopleCount;
        this.holidayPackageReservation = holidayPackageReservation;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }
}
