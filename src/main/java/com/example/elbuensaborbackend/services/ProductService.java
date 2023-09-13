package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.entities.Product;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService extends BaseService<Product,Long>{
    @Transactional
    Product saveWithImage(Product product) throws Exception;
}
