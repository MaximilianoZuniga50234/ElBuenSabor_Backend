package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.entities.ItemStock;

public interface ItemStockService extends BaseService<ItemStock,Long>{
    boolean leave(Long id) throws Exception;
}
