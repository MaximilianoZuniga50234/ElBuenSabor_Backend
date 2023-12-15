package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductRepository;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public Product saveWithImage(Product product, Optional<MultipartFile> image) throws Exception {
        try {
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                product.setImgUrl(result.get("secure_url").toString());
                product.setImgId(result.get("public_id").toString());
            }
            product = productRepository.save(product);
            return product;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product updateWithImage(Product product, Optional<MultipartFile> image, Long id) throws Exception {
        try {
            Optional<Product> oldProduct = productRepository.findById(id);
            if (oldProduct.isEmpty()) {
                throw new Exception("No se encontró el producto con el id: " + id);
            }
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                product.setImgUrl(result.get("secure_url").toString());
                product.setImgId(result.get("public_id").toString());
            }
            Product existingProduct = oldProduct.get();
            product.setId(existingProduct.getId());
            existingProduct = product;
            return productRepository.save(existingProduct);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public boolean deleteWithImage(Long id) throws Exception {
        try {
            if (productRepository.existsById(id)) {
                cloudinaryService.delete(productRepository.findById(id).get().getImgId());
                productRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("El producto no existe");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean leave(Long id) throws Exception {
        try{
            if(productRepository.existsById(id)) {
                Product existingProduct = productRepository.findById(id).get();
                existingProduct.setActive(false);
                productRepository.save(existingProduct);
                return true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findProductForDenomination(String denomination) throws Exception{
        try {
            return productRepository.findByDenominationContaining(denomination);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findProductsByCategory(String denomination) throws Exception{
        try {
            return productRepository.findByItemProduct_Denomination(denomination);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
