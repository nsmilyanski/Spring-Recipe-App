package com.springframework.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(Long racipeId, MultipartFile file);
}
