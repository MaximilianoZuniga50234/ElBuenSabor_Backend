package com.example.elbuensaborbackend.models.entities;

import com.example.elbuensaborbackend.util.ItemStockSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_stock")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize(using = ItemStockSerializer.class)
public class ItemStock extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private ItemStock father;
}
