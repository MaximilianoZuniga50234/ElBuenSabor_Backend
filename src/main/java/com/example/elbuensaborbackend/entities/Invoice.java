package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
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

    @Column(name = "discount_amount")
    private double discountAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_sale")
    private double totalSale;

    @Column(name = "total_cost")
    private double totalCost;

}
