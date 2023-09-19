package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.dtos.UserDTO;
import com.example.elbuensaborbackend.models.entities.User;

import java.util.List;

public interface UserService extends BaseService<User,Long>{

    List<UserDTO> getUsersDTOs();
}
