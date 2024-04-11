package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Stock;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.StockRepository;
import com.example.elbuensaborbackend.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl extends BaseServiceImpl<Stock, Long> implements StockService {

    @Autowired
    private StockRepository stockRepository;

    public StockServiceImpl(BaseRepository<Stock, Long> stockRepository) {
        super(stockRepository);
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
            return stockRepository.getAllIngredients();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
