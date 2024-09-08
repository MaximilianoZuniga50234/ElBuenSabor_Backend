package com.example.elbuensaborbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder extends Base {

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "number")
    private int number;

    @Column(name = "estimated_end_time")
    private double estimatedEndTime;

    @Column(name = "shipping_type")
    private String shippingType;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total")
    private double total;

    @Column(name = "amount_to_paid")
    private double amountToPaid;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id")
    private Status status;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PurchaseOrderDetail> details = new ArrayList<>();

}
