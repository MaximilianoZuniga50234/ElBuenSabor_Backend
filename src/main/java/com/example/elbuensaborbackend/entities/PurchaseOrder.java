package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

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
    private Time estimatedEndTime;

    @Column(name = "shipping_type")
    private String shippingType;

    @Column(name = "total")
    private double total;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address addressId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "person_id")
    private Person personId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "state_id")
    private State stateId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
    private Invoice invoiceId;

}
