package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mercadoPagoData_Order")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoData_Order extends Base {
}
