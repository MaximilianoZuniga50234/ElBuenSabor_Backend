package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductRepository;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    private final String NO_IMAGE_PRODUCT_URL = "https://res.cloudinary.com/dfdb0nwad/image/upload/v1712072796/image-2935360_1920_ig8cze_fqw8ji.png";
    private final String NO_IMAGE_PRODUCT_ID = "image-2935360_1920_ig8cze_fqw8ji";

    public ProductServiceImpl(BaseRepository<Product, Long> productRepository) {
        super(productRepository);
    }

    @Transactional
    public Product saveWithImage(String product, Optional<MultipartFile> image) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Product productObj = objectMapper.readValue(product, Product.class);

            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                productObj.setImgUrl(result.get("secure_url").toString());
                productObj.setImgId(result.get("public_id").toString());
            } else {
                productObj.setImgUrl(NO_IMAGE_PRODUCT_URL);
                productObj.setImgId(NO_IMAGE_PRODUCT_ID);
            }
            productObj = productRepository.save(productObj);
            return productObj;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Product updateWithImage(String product, Optional<MultipartFile> image, Long id) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Product productObj = objectMapper.readValue(product, Product.class);

            Optional<Product> oldProduct = productRepository.findById(id);
            if (oldProduct.isEmpty()) {
                throw new Exception("No se encontró el producto con el id: " + id);
            }
            if (image.isPresent()) {
                Map<String, ?> result = cloudinaryService.upload(image.get());
                productObj.setImgUrl(result.get("secure_url").toString());
                productObj.setImgId(result.get("public_id").toString());
            }
            Product existingProduct = oldProduct.get();
            productObj.setId(existingProduct.getId());
            existingProduct = productObj;
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

    public Product leave(Long id) throws Exception {
        try {
            if (productRepository.existsById(id)) {
                Product existingProduct = productRepository.findById(id).get();
                existingProduct.setActive(false);
                return productRepository.save(existingProduct);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*public List<Product> findAll(String name, String order, String category, String min, String max) throws Exception {
        try {
            return productRepository.findProductsByFilters(name,
                            category == null ? null : Long.parseLong(category),
                            min == null ? null : Double.parseDouble(min),
                            max == null ? null : Double.parseDouble(max),
                            order == null ? null : Integer.parseInt(order))
                    .stream()
                    .sorted(Comparator.comparing(Product::isActive)
                            .reversed())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/

    public List<Product> findAllFeatured() throws Exception {
        try {
            Random r = new Random();
            List<Product> activeProducts = productRepository.findAll()
                                                            .stream()
                                                            .filter(Product::isActive)
                                                            .toList();

            return r.ints(0, activeProducts.size())
                    .distinct()
                    .limit(activeProducts.size() / 2)
                    .mapToObj(activeProducts::get)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findAllSale() throws Exception {
        try {
            return productRepository.findAllByDiscountPercentajeGreaterThan(0.0)
                    .stream()
                    .filter(Product::isActive)
                    .sorted(Comparator.comparing(Product::getDenomination))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
