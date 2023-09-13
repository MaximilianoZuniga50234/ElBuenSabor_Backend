package com.example.elbuensaborbackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "discount_percentaje")
    private double discountPercentaje;

    @Column(name = "image_url")
    private String imgUrl;

    @Column(name = "image_id")
    private String imgId;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemProduct_id")
    private ItemProduct itemProduct;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProductDetail> details = new ArrayList<>();

}
