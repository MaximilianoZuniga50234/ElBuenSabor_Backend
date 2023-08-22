package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends Base {
    @Column(name = "denomination")
    private String denomination;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "current_stock")
    private double currentStock;

    @Column(name = "minimum_stock")
    private double minimumStock;

    @Column(name = "is_stock")
    private boolean isStock;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "measurementUnit_id")
    private MeasurementUnit measurementUnit;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemStock_id")
    private ItemStock itemStock;
}
