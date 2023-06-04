package com.example.elbuensaborbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mercadoPagoData_Invoice")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoData_Invoice extends Base{
}
