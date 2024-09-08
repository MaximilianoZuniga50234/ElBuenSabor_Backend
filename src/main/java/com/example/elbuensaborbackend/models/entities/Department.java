package com.example.elbuensaborbackend.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Department extends Base {

    @Column(name = "name")
    private String name;
}
