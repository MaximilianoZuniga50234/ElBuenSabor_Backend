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
@Table(name = "credit_note")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditNote extends Base {

    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private double total;

    @Column(name = "active")
    private boolean active;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

}
