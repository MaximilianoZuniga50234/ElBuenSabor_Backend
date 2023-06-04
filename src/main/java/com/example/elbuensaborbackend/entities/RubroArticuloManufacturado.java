package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rubroArticuloManufacturado")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RubroArticuloManufacturado extends Base {

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "leave_status")
    private boolean leaveStatus;

}
