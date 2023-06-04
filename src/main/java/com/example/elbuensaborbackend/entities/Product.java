package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends Base {


    @Column(name = "estimated_time_kitchen")
    private int estimatedTimeKitchen;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "image")
    private String image;

    @Column(name = "leave_status")
    private boolean leaveStatus;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemProduct_id")
    private ItemProduct itemProductId;
}
