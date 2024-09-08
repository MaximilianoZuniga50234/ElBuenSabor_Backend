package com.example.elbuensaborbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private PurchaseOrder order;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "stock_id")
    private Stock stock;
}
