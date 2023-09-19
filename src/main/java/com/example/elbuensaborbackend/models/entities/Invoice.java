package com.example.elbuensaborbackend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoice")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends Base {

    @Column(name = "date")
    private Date date;

    @Column(name = "discount_amount")
    private double discountAmount;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "total_sale")
    private double totalSale;

    @Column(name = "total_cost")
    private double totalCost;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mercado_pago_data_id")
    private MercadoPagoData mercadoPagoData;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceDetail> details = new ArrayList<>();
}
