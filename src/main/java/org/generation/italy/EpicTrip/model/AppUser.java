package org.generation.italy.EpicTrip.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "app_user")
public class AppUser {
    public AppUser(long id, String firstname, String lastname, LocalDate birthdate, String telephoneNumber, String country, String city, String street, int houseNumber, String postalCode, String email, String gender) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.telephoneNumber = telephoneNumber;
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.email = email;
        this.gender = gender;
    }
    public AppUser(long id, String firstname, String lastname, LocalDate birthdate, String telephoneNumber, String country, String city, String street, int houseNumber, String postalCode, String email, String gender, String password) {
        this(id, firstname, lastname, birthdate, telephoneNumber, country, city, street, houseNumber,  postalCode, email, gender);
        this.password = password;
    }

    public AppUser(long id) {
        this.id = id;
    }

    public AppUser() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname", nullable = false, length = 32)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 32)
    private String lastname;

    @Column(name = "birthdate", columnDefinition = "date", nullable = false)
    private LocalDate birthdate;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "country", nullable = false, length = 32)
    private String country;

    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Column(name = "street", nullable = false, length = 128)
    private String street;

    @Column(name = "house_number", nullable = false)
    private int houseNumber;

    @Column(name = "postal_code", nullable = false, length = 32)
    private String postalCode;

    @Column(name = "email", nullable = false, length = 32)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "gender", nullable = true, length = 32)
    private String gender;

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

