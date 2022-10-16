package kr.rhinitis.secondduoproject.image.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
//TODO 이미지등록,삭제
public class ImageServiceImpl implements ImageService{
    @Override
    public Map<String, Object> uploadImage(MultipartFile image) {
        return null;
    }

    @Override
    public void deleteImage(Long imageId) {

    }
}
