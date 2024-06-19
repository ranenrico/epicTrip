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
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 32)
    private String lastname;

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

    public Guide(long id, String firstname, String lastname, String telephoneNumber, String email, String introduction, String workplace) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.introduction = introduction;
        this.workplace = workplace;
    }

    public Guide(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getWorkplace() {
        return workplace;
    }
}
