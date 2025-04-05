package com.team3.sr.java.miniproject.services;

import com.team3.sr.java.miniproject.model.entity.FileMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {
    FileMetadata uploadFile(MultipartFile file);

    InputStream getFileByFileName(String fileName);
}
