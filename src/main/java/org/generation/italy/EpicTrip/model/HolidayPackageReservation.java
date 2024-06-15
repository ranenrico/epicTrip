package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "package_reservation")
public class HolidayPackageReservation {
    public HolidayPackageReservation() {
    }

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

}
