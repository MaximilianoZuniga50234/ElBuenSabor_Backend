package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE " +
            "(:name IS NULL OR p.denomination LIKE %:name%) AND " +
            "(:itemProduct IS NULL OR p.itemProduct.id = :itemProduct) AND " +
            "(:salePriceMin IS NULL OR p.salePrice >= :salePriceMin) AND " +
            "(:salePriceMax IS NULL OR p.salePrice < :salePriceMax)" +
            "ORDER BY " +
            "CASE WHEN :order = 1 THEN p.denomination END ASC, " +
            "CASE WHEN :order = 2 THEN p.denomination END DESC, " +
            "CASE WHEN :order = 3 THEN p.salePrice END ASC, " +
            "CASE WHEN :order = 4 THEN p.salePrice END DESC ")
    List<Product> findProductsByFilters(@Param("name") String name,
                                        @Param("itemProduct") Long category,
                                        @Param("salePriceMin") Double min,
                                        @Param("salePriceMax") Double max,
                                        @Param("order") Integer order);

    List<Product> findAllByDiscountPercentajeGreaterThan(Double discount);

    /*List<Product> findByDenominationContaining(String denomination);
    List<Product> findByItemProduct_Denomination(String category);
    List<Product> findAllBySalePriceGreaterThanEqualAndSalePriceLessThan(Double min, Double max);
    List<Product> findAllBySalePriceGreaterThanEqual(Double min);
    List<Product> findAllBySalePriceLessThan(Double max);*/
}

