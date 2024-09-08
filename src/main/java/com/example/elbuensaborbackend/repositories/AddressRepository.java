package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Address;
import com.example.elbuensaborbackend.models.entities.Person;
import com.example.elbuensaborbackend.models.entities.PurchaseOrder;
import com.example.elbuensaborbackend.models.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends BaseRepository<Address, Long>{

    @Query("SELECT a FROM Address a WHERE a.person = :person")
    List<Address> addressByPerson(@Param("person") Person person);
}
