package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.models.entities.Stock;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface StockService extends BaseService<Stock, Long> {
    boolean leave(Long id) throws Exception;
    List<Stock> getOnlyIngredients() throws Exception;
    List<Stock> getNotIngredients() throws Exception;

    Stock saveWithImage(String stock, Optional<MultipartFile> image) throws Exception;

    Stock updateWithImage(String stock, Optional<MultipartFile> image, Long id) throws Exception;

}
