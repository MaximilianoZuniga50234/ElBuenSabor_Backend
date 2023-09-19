package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.ItemProduct;

public interface ItemProductService extends BaseService<ItemProduct,Long>{

    boolean leave(Long id) throws Exception;
}
