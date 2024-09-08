package com.example.elbuensaborbackend.models.entities;

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
public class ItemStock extends Base {
    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private ItemStock father;
}
