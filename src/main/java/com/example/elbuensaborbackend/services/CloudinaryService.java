package com.example.elbuensaborbackend.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    Map<String, ?> upload(MultipartFile multipartFile) throws IOException;
    Map<String, String> delete(String id) throws IOException;
}
