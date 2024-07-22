package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.Stock;

import java.util.List;

public interface StockService extends BaseService<Stock, Long> {
    boolean leave(Long id) throws Exception;
    List<Stock> getOnlyIngredients() throws Exception;
    List<Stock> getNotIngredients() throws Exception;
}
