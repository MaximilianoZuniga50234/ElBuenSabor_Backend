package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.ItemProduct;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ItemProductRepository;
import com.example.elbuensaborbackend.services.ItemProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemProductServiceImpl extends BaseServiceImpl<ItemProduct, Long> implements ItemProductService {

    @Autowired
    private ItemProductRepository itemProductRepository;

    public ItemProductServiceImpl(BaseRepository<ItemProduct, Long> itemProductRepository) {
        super(itemProductRepository);
    }

    @Override
    public List<ItemProduct> findAll() throws Exception {
        try {
            return itemProductRepository.findAll().stream()
                    .sorted(Comparator.comparing(ItemProduct::isActive)
                            .reversed()
                            .thenComparing(ItemProduct::getDenomination))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean leave(Long id) throws Exception {
        try {
            if (itemProductRepository.existsById(id)) {
                ItemProduct existingItemProduct = itemProductRepository.findById(id).get();
                existingItemProduct.setActive(false);
                itemProductRepository.save(existingItemProduct);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
