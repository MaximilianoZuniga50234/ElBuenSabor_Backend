package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.ProductDetail;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductDetailRepository;
import com.example.elbuensaborbackend.services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl extends BaseServiceImpl<ProductDetail, Long> implements ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    public ProductDetailServiceImpl(BaseRepository<ProductDetail, Long> productDetailRepository) {
        super(productDetailRepository);
    }

}
