package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long>{
}
