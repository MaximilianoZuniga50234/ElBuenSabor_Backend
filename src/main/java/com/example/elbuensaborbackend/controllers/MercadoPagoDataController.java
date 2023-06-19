package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.MercadoPagoData;
import com.example.elbuensaborbackend.services.Implementation.MercadoPagoDataServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/mercadoPagoData")
public class MercadoPagoDataController extends BaseControllerImpl<MercadoPagoData, MercadoPagoDataServiceImpl> {
}
