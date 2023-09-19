package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends BaseRepository<PurchaseOrder, Long>{

    @Query("SELECT o FROM PurchaseOrder o WHERE o.user = :user")
    List<PurchaseOrder> ordersByUser(@Param("user") User user);
}
