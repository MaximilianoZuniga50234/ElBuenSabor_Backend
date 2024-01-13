package com.example.elbuensaborbackend.services.Implementation;

import com.example.elbuensaborbackend.models.entities.Product;
import com.example.elbuensaborbackend.repositories.BaseRepository;
import com.example.elbuensaborbackend.repositories.ProductRepository;
import com.example.elbuensaborbackend.services.CloudinaryService;
import com.example.elbuensaborbackend.services.ProductService;
import org.apache.commons.lang3.ObjectUtils;
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
        try {
            if (productRepository.existsById(id)) {
                Product existingProduct = productRepository.findById(id).get();
                existingProduct.setActive(false);
                productRepository.save(existingProduct);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findAll(String name, String order, String category, String min, String max) throws Exception {
        try {
            return productRepository.findProductsByFilters(name,
                    category == null ? null : Long.parseLong(category),
                    min == null ? null : Double.parseDouble(min),
                    max == null ? null : Double.parseDouble(max),
                    order == null ? null : Integer.parseInt(order));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findAllFeatured() throws Exception {
        try {
            Random r = new Random();
            List<Product> products = productRepository.findAll();

            return r.ints(0, products.size())
                    .distinct()
                    .limit(products.size() / 2)
                    .mapToObj(products::get)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findAllSale() throws Exception {
        try {
            return productRepository.findAllByDiscountPercentajeGreaterThan(0.0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /*public List<Product> findProductForDenomination(String denomination) throws Exception {
        try {
            return productRepository.findByDenominationContaining(denomination);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findProductsByCategory(String denomination) throws Exception {
        try {
            return productRepository.findByItemProduct_Denomination(denomination);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Product> findProductsByPrice(String min, String max) throws Exception {
        try {
            if (ObjectUtils.isNotEmpty(min) && ObjectUtils.isNotEmpty(max)) {
                return productRepository.
                        findAllBySalePriceGreaterThanEqualAndSalePriceLessThan(
                                Double.parseDouble(min),
                                Double.parseDouble(max));
            }
            if (ObjectUtils.isEmpty(max)) {
                return productRepository.findAllBySalePriceGreaterThanEqual(Double.parseDouble(min));
            }
            if (ObjectUtils.isEmpty(min)) {
                return productRepository.findAllBySalePriceLessThan(Double.parseDouble(max));
            }
            throw new Exception();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/
}
