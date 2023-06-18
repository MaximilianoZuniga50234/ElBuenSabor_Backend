package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Stock;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.StockRepository;
import com.example.elbuensaborbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;

public class StockServiceImpl extends BaseServiceImpl<Stock, Long> implements StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockServiceImpl(BaseRepository<Stock, Long> stockRepository) {
        super(stockRepository);
    }
}
