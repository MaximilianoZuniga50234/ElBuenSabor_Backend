package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articuloInsumo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumo extends Base {
    @Column(name="denomination")
    private String denomination;

    @Column(name="purchasePrice")
    private double purchasePrice;

    @Column(name="salePrice")
    private double salePrice;

    @Column(name="currentStock")
    private double currentStock;

    @Column(name="minimumStock")
    private double minimumStock;

    @Column(name="esInsumo")
    private boolean esInsumo;

    @Column(name = "leave_status")
    private boolean leaveStatus;
}
