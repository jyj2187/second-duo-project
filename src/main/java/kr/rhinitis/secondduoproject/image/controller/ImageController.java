package kr.rhinitis.secondduoproject.image.controller;

import kr.rhinitis.secondduoproject.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity uploadImage(@RequestParam("image") MultipartFile multipartFile){
        Map<String, Object> response = imageService.uploadImage(multipartFile);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
