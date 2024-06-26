package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "guide_reservation")
public class GuideReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "guide_id", nullable = false)
    private Guide guide;

    @ManyToOne
    @JoinColumn(name = "package_reservation_id", nullable = false)
    private HolidayPackageReservation holidayPackageReservation;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "start_performance_date", nullable = false)
    private LocalDate startPerformanceDate;

    @Column(name = "end_performance_date", nullable = false)
    private LocalDate endPerformanceDate;

    public GuideReservation(Guide guide, HolidayPackageReservation holidayPackageReservation, LocalDate reservationDate, LocalDate startPerformanceDate, LocalDate endPerformanceDate) {
        this.guide = guide;
        this.holidayPackageReservation = holidayPackageReservation;
        this.reservationDate = reservationDate;
        this.startPerformanceDate = startPerformanceDate;
        this.endPerformanceDate = endPerformanceDate;
    }

    public GuideReservation() {
    }

    public long getId() {
        return id;
    }

    public LocalDate getStartPerformanceDate() {
        return startPerformanceDate;
    }

    public LocalDate getEndPerformanceDate() {
        return endPerformanceDate;
    }
}