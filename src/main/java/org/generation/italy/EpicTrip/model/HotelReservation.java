package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "hotel_reservation")
public class HotelReservation {
    public HotelReservation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "check_in", nullable = false)
    private LocalDateTime checkIn;

    @Column(name = "check_out", nullable = false)
    private LocalDateTime checkOut;

    @ManyToOne
    @JoinColumn(name = "package_reservation_id", nullable = false)
    private HolidayPackageReservation holidayPackageReservation;

    @Column(name = "people_count", nullable = false)
    private int peopleCount;

}
