package com.example.elbuensaborbackend.repositories;

import com.example.elbuensaborbackend.models.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
}
