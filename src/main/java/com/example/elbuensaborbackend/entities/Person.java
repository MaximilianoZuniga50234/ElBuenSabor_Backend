package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Base {

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "email")
    private String email;

}
