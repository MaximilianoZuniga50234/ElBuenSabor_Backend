package com.example.elbuensaborbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

}
