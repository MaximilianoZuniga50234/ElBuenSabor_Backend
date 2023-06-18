package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.entities.Stock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends BaseRepository<Stock, Long>{
}
