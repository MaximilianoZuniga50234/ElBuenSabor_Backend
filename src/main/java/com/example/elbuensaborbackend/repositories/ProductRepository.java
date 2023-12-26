package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
    List<Product> findByDenominationContaining(String denomination);
    List<Product> findByItemProduct_Denomination(String category);

    List<Product> findAllBySalePriceGreaterThanEqualAndSalePriceLessThan(Double min, Double max);
    List<Product> findAllBySalePriceGreaterThanEqual(Double min);
    List<Product> findAllBySalePriceLessThan(Double max);
}

