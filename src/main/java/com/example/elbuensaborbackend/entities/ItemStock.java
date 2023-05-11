package com.example.elbuensaborbackend.entities;

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
public class ItemStock extends Base{

    @Column(name = "name")
    private String name;
    @Column(name = "leave_status")
    private boolean leaveStatus;

    @ManyToOne()
    @JoinColumn(name = "fatherId")
    private ItemStock fatherId;

}
