package kr.rhinitis.secondduoproject.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {
    Map<String, Object> uploadImage(MultipartFile image);
    void deleteImage(Long imageId);
}
