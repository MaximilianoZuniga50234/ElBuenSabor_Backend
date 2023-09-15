package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.entities.Stock;

public interface StockService extends BaseService<Stock,Long>{
    boolean leave(Long id) throws Exception;
}
