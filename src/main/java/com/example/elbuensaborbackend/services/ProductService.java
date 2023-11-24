package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService extends BaseService<Product, Long> {
    Product saveWithImage(Product product, Optional<MultipartFile> image) throws Exception;

    Product updateWithImage(Product product, Optional<MultipartFile> image, Long id) throws Exception;

    boolean deleteWithImage(Long id) throws Exception;

    boolean leave(Long id) throws Exception;

    List<Product> findProductForDenomination(String denomination) throws Exception;
}
