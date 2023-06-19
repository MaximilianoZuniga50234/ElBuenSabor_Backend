package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Product;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductRepository;
import com.example.elbuensaborbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(BaseRepository<Product, Long> productRepository) {
        super(productRepository);
    }

}
