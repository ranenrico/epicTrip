package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "attraction_visit")
public class AttractionVisit {
    public AttractionVisit() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;

    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private HolidayPackage holidayPackage;

    @Column(name = "attraction_order", nullable = false)
    private int attractionOrder;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(name = "visit_day")
    private int visitDay;

    public long getId() {
        return id;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public int getAttractionOrder() {
        return attractionOrder;
    }

    public int getVisitDay() {
        return visitDay;
    }
}