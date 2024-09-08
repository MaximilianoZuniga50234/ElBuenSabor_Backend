package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends BaseRepository<Stock, Long> {

    @Query(value = "SELECT * FROM stock WHERE is_stock = TRUE", nativeQuery = true)
    List<Stock> getAllIngredients();

    @Query(value = "SELECT s FROM Stock s WHERE s.isStock = FALSE ORDER BY s.denomination ASC")
    List<Stock> getNotIngredients();
}
