package com.hci.hcionlineshop.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String firstName;
    private String username;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    @ManyToOne
    private Address shippingAddress;
    private String password;
}
