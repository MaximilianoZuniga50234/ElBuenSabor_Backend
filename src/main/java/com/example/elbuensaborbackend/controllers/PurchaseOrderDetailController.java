package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.PurchaseOrderDetail;
import com.example.elbuensaborbackend.services.Implementation.PurchaseOrderDetailServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/purchaseOrderDetail")
public class PurchaseOrderDetailController extends BaseControllerImpl<PurchaseOrderDetail, PurchaseOrderDetailServiceImpl> {
}
