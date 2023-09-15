package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.ItemProduct;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ItemProductRepository;
import com.example.elbuensaborbackend.services.ItemProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemProductServiceImpl extends BaseServiceImpl<ItemProduct, Long> implements ItemProductService {

    @Autowired
    private ItemProductRepository itemProductRepository;

    public ItemProductServiceImpl(BaseRepository<ItemProduct, Long> itemProductRepository) {
        super(itemProductRepository);
    }

    public boolean leave(Long id) throws Exception {
        try{
            if(itemProductRepository.existsById(id)) {
                ItemProduct existingItemProduct = itemProductRepository.findById(id).get();
                existingItemProduct.setActive(false);
                itemProductRepository.save(existingItemProduct);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
