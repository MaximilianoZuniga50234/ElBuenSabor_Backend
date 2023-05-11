package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "measurement_unit")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementUnit extends Base{

    @Column(name = "name")
    private String name;
    @Column(name = "leave_status")
    private boolean leaveStatus;

}
