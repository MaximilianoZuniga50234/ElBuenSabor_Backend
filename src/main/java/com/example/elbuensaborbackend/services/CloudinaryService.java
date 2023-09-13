package com.example.elbuensaborbackend.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryService {

    Cloudinary cloudinary;

    private final Map<String, String> valuesMap = new HashMap<>();

    public CloudinaryService(){
        valuesMap.put("cloud_name", "dycogxoko");
        valuesMap.put("api_key", "755738381293712");
        valuesMap.put("api_secret", "keCyEZxeLQ-cJEseiAWMbuB6Tt4");
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map<String, ?> upload(MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map<String, ?> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map<String, String> delete(String id) throws IOException {
        return (Map<String, String>) cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return file;
    }
}
