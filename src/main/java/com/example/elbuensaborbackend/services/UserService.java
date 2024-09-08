package com.example.elbuensaborbackend.services;

import com.example.elbuensaborbackend.models.dtos.UserDTO;
import com.example.elbuensaborbackend.models.entities.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<User, Long> {

    List<UserDTO> getUsersDTOs() throws Exception;

    User createWithImage(User user, Optional<MultipartFile> image) throws Exception;

    User updateWithImage(User user, Optional<MultipartFile> image, Long id) throws Exception;
}
