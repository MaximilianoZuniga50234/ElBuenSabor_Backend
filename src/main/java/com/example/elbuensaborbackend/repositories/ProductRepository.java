package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    List<Product> findByDenominationContaining(String denomination);
}

