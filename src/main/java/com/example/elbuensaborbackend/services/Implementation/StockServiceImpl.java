package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Stock;
import com.example.elbuensaborbackend.models.entities.Stock;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.StockRepository;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock, Long> implements StockService {

    @Autowired
    private StockRepository stockRepository;
    
    @Autowired
    private CloudinaryService cloudinaryService;

    private final String NO_IMAGE_STOCK_URL = "https://res.cloudinary.com/dfdb0nwad/image/upload/v1712072796/image-2935360_1920_ig8cze_fqw8ji.png";
    private final String NO_IMAGE_STOCK_ID = "image-2935360_1920_ig8cze_fqw8ji";
    public StockServiceImpl(BaseRepository<Stock, Long> stockRepository) {
        super(stockRepository);
    }

    @Transactional
    public Stock saveWithImage(String stock, Optional<MultipartFile> image) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Stock stockObj = objectMapper.readValue(stock, Stock.class);

            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                stockObj.setImgUrl(result.get("secure_url").toString());
                stockObj.setImgId(result.get("public_id").toString());
            } else {
                stockObj.setImgUrl(NO_IMAGE_STOCK_URL);
                stockObj.setImgId(NO_IMAGE_STOCK_ID);
            }
            stockObj = stockRepository.save(stockObj);
            return stockObj;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Stock updateWithImage(String stock, Optional<MultipartFile> image, Long id) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Stock stockObj = objectMapper.readValue(stock, Stock.class);

            Optional<Stock> oldStock = stockRepository.findById(id);
            if (oldStock.isEmpty()) {
                throw new Exception("No se encontró el ingrediente con el id: " + id);
            }
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                stockObj.setImgUrl(result.get("secure_url").toString());
                stockObj.setImgId(result.get("public_id").toString());
            }
            Stock existingStock = oldStock.get();
            stockObj.setId(existingStock.getId());
            existingStock = stockObj;
            return stockRepository.save(existingStock);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean leave(Long id) throws Exception {
        try{
            if(stockRepository.existsById(id)) {
                Stock existingStock = stockRepository.findById(id).get();
                existingStock.setActive(false);
                stockRepository.save(existingStock);
                return true;
            }else{
                throw new Exception("Stock no encontrado con id: " + id);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Stock> getOnlyIngredients() throws Exception {
        try{
            return stockRepository.getAllIngredients().stream()
                    .sorted(Comparator.comparing(Stock::isActive)
                            .reversed()
                            .thenComparing(Stock::getDenomination))
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Stock> getNotIngredients() throws Exception {
        try{
            return stockRepository.getNotIngredients()
                    .stream()
                    .sorted(Comparator.comparing(Stock::isActive)
                            .reversed())
                    .collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
