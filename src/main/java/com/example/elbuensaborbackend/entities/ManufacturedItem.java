package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manufacturedItem")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturedItem extends Base {


    @Column(name = "estimatedTimeKitchen")
    private int estimatedTimeKitchen;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "salePrice")
    private double salePrice;

    @Column(name = "image")
    private String image;

    @Column(name = "leave_status")
    private boolean leaveStatus;
}
