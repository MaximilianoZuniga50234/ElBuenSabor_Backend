package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.entities.Product;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductRepository;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public ProductServiceImpl(BaseRepository<Product, Long> productRepository) {
        super(productRepository);
    }
    @Transactional
    public Product saveWithImage(Product product, MultipartFile image) throws Exception {
        try{
            Map<String, ?> result = cloudinaryService.upload(image);
            product.setImgUrl(result.get("secure_url").toString());
            product.setImgId(result.get("public_id").toString());
            product = productRepository.save(product);
            return product;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean deleteWithImage(Long id) throws Exception {
        try{
            if(productRepository.existsById(id)) {
                cloudinaryService.delete(productRepository.findById(id).get().getImgId());
                productRepository.deleteById(id);
                return true;
            }else{
                throw new Exception("El producto no existe");
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
