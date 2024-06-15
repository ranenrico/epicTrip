package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "guide")
public class Guide {
    public Guide() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname", nullable = false, length = 32)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 32)
    private String lastName;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "telephone_number", nullable = false, length = 16)
    private String telephoneNumber;

    @Column(name = "country", nullable = false, length = 16)
    private String country;

    @Column(name = "city", nullable = false, length = 16)
    private String city;

    @Column(name = "street", nullable = false, length = 32)
    private String street;

    @Column(name = "house_number", nullable = false)
    private int houseNumber;

    @Column(name = "postal_code", nullable = false, length = 16)
    private String postalCode;

    @Column(name = "email", nullable = false, length = 32)
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "introduction", nullable = false, length = 1024)
    private String introduction;

    @Column(name = "workplace", nullable = false, length = 32)
    private String workplace;

}
