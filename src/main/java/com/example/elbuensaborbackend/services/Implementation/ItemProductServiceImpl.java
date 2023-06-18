package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.ItemProduct;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ItemProductRepository;
import com.example.elbuensaborbackend.services.ItemProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemProductServiceImpl extends BaseServiceImpl<ItemProduct, Long> implements ItemProductService {

    @Autowired
    private ItemProductRepository itemProductRepository;

    public ItemProductServiceImpl(BaseRepository<ItemProduct, Long> itemProductRepository) {
        super(itemProductRepository);
    }
}
