package com.hci.hcionlineshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    public Long id;
    private String houseNumber;
    private String street;
    private String city;
    private String country;
    private String postCode;

    public Address(String houseNumber, String street, String city, String country, String postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }

    public String toString() {
        return houseNumber + ", " + street + "\n" + city + ", " + country + ", " + postCode;
    }
}
