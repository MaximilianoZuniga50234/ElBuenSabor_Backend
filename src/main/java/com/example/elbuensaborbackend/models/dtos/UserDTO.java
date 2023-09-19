package com.example.elbuensaborbackend.models.dtos;

import com.example.elbuensaborbackend.models.entities.Address;
import com.example.elbuensaborbackend.models.entities.Invoice;
import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private String telephone;
    private String role;
    private List<PurchaseOrder> orders;
    private List<Address> addresses;
    private List<Invoice> invoices;
}
