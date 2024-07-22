package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService extends BaseService<Product, Long> {
    Product saveWithImage(String product, Optional<MultipartFile> image) throws Exception;

    Product updateWithImage(String product, Optional<MultipartFile> image, Long id) throws Exception;

    boolean deleteWithImage(Long id) throws Exception;

    Product leave(Long id) throws Exception;

//    List<Product> findAll(String name, String order, String category, String min, String max) throws Exception;
    List<Product> findAllFeatured() throws Exception;
    List<Product> findAllSale() throws Exception;
//    List<Product> findProductForDenomination(String denomination) throws Exception;
//    List<Product> findProductsByCategory(String category) throws Exception;
//    List<Product> findProductsByPrice(String min, String max) throws Exception;
}
