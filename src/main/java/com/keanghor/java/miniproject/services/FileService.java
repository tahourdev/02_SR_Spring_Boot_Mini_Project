package com.keanghor.java.miniproject.services;

import com.keanghor.java.miniproject.model.entity.FileMetadata;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    FileMetadata uploadFile(MultipartFile file);

    Resource getFileByFileName(String fileName);
}
