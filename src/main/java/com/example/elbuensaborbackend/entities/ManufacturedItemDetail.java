package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "manufacturatedItemDetail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturedItemDetail extends Base {

    @Column(name = "amount")
    private double amount;


}
