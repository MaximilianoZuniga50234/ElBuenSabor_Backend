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
@Table(name = "mercadoPagoData")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoData extends Base {

    @Column(name = "paymentIdentifier")
    private long paymentIdentifier;

    @Column(name = "creationDate")
    private Date creatioDate;

    @Column(name = "approvalDate")
    private Date approvalDate;

    @Column(name = "paymentMethod")
    private String paymentMehod;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "state")
    private String state;
}
