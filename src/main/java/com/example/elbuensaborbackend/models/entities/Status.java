package com.example.elbuensaborbackend.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Status extends Base {

    @Column(name = "status")
    private String status;
}
