package com.example.elbuensaborbackend.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoProduct {

    //Person payer;
    String title;
    float price;
    int quantity;

}
