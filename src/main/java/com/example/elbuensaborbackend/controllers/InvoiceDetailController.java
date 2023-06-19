package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.InvoiceDetail;
import com.example.elbuensaborbackend.services.Implementation.InvoiceDetailServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/invoiceDetail")
public class InvoiceDetailController extends BaseControllerImpl<InvoiceDetail, InvoiceDetailServiceImpl> {
}
