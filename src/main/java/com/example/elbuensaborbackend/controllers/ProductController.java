package com.example.elbuensaborbackend.controllers;

import com.example.elbuensaborbackend.controllers.BaseControllerImpl.BaseControllerImpl;
import com.example.elbuensaborbackend.entities.Product;
import com.example.elbuensaborbackend.services.Implementation.ProductServiceImpl;
import com.example.elbuensaborbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/product")
public class ProductController extends BaseControllerImpl<Product, ProductServiceImpl>{

    @Autowired
    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> saveWithImage(@RequestPart("product") Product product,
                                           @RequestPart("image") MultipartFile image){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(productService.saveWithImage(product));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":\"Error, por favor intente nuevamente...\"");
        }
    }

}
