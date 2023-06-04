package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "invoice")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends Base {

    @Column(name = "date")
    private Date date;

    @Column(name = "number")
    private long number;

    @Column(name = "discountAmount")
    private double discountAmount;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "totalSale")
    private double totalSale;

    @Column(name = "totalCost")
    private double totalCost;

}
