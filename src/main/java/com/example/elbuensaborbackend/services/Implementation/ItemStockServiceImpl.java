package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.ItemStock;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ItemStockRepository;
import com.example.elbuensaborbackend.services.ItemStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemStockServiceImpl extends BaseServiceImpl<ItemStock, Long> implements ItemStockService {

    @Autowired
    private ItemStockRepository itemStockRepository;

    public ItemStockServiceImpl(BaseRepository<ItemStock, Long> baseRepository) {
        super(baseRepository);
    }
}
