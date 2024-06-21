package com.example.elbuensaborbackend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock extends Base {
    @Column(name = "denomination")
    private String denomination;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "current_stock")
    private double currentStock;

    @Column(name = "minimum_stock")
    private double minimumStock;

    @Column(name = "is_stock")
    private boolean isStock;

    @Column(name = "active")
    private boolean active;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "measurementUnit_id")
    private MeasurementUnit measurementUnit;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "itemStock_id")
    private ItemStock itemStock;

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(double currentStock) {
        this.currentStock = currentStock;
    }

    public double getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(double minimumStock) {
        this.minimumStock = minimumStock;
    }

    public boolean getIsStock() {
        return isStock;
    }

    public void setIsStock(boolean isStock) {
        this.isStock = isStock;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public MeasurementUnit getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnit measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public ItemStock getItemStock() {
        return itemStock;
    }

    public void setItemStock(ItemStock itemStock) {
        this.itemStock = itemStock;
    }
}
