package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.entities.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService extends BaseService<Product,Long>{
    Product saveWithImage(Product product, MultipartFile image) throws Exception;
    boolean deleteWithImage(Long id) throws Exception;
}
