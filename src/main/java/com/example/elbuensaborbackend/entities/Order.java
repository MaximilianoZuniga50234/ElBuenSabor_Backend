package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends Base {

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "number")
    private int number;

    @Column(name = "estimatedEndTime")
    private Time estimatedEndTime;

    @Column(name = "shippingType")
    private String shippingType;

    @Column(name = "total")
    private double total;


}
