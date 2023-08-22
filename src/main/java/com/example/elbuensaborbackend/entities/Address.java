package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends Base {

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person person;

}
