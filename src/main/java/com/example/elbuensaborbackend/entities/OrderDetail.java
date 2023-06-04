package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderDetail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends Base {

    @Column(name = "amount")
    private int amount;

    @Column(name = "subtotal")
    private double subtotal;
}
