package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_order_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrderDetail extends Base {

    @Column(name = "amount")
    private int amount;

    @Column(name = "subtotal")
    private double subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private PurchaseOrder orderId;
}
