package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long>{
}
