package com.example.elbuensaborbackend.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "mercado_pago_data")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MercadoPagoData extends Base {

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Column(name = "collection_id")
    private String collectionId;

    @Column(name = "collection_status")
    private String collectionStatus;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "status")
    private String status;

    @Column(name = "external_reference")
    private String externalReference;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "merchant_order_id")
    private String merchantOrderId;

    @Column(name = "preference_id")
    private String preferenceId;

    @Column(name = "site_id")
    private String siteId;

    @Column(name = "processing_mode")
    private String processingMode;

    @Column(name = "merchant_account_id")
    private String merchantAccountId;
}
