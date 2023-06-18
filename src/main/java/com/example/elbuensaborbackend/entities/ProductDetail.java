package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_detail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail extends Base {

    @Column(name = "amount")
    private double amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product productId;

}
