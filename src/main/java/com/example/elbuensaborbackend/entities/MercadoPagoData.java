package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
}
