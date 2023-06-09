package com.example.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mercado_pago_data")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoData extends Base {

    @Column(name = "payment_identifier")
    private long paymentIdentifier;

    @Column(name = "creation_date")
    private Date creatioDate;

    @Column(name = "approval_date")
    private Date approvalDate;

    @Column(name = "payment_method")
    private String paymentMehod;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "state")
    private String state;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "mercadoPagoData_order", joinColumns = @JoinColumn(name = "mercadoPagoData_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<PurchaseOrder> orders = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "mercadoPagoData_invoice", joinColumns = @JoinColumn(name = "mercadoPagoData_id"), inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    private List<Invoice> invoices = new ArrayList<>();
}
