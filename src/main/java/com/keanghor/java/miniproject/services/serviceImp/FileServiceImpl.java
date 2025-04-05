package com.keanghor.java.miniproject.services.serviceImp;

import com.keanghor.java.miniproject.model.entity.FileMetadata;
import com.keanghor.java.miniproject.services.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${spring.upload-file-path}")
    private String pathName;

    @SneakyThrows
    @Override
    public FileMetadata uploadFile(MultipartFile file) {
        Path rootPath = Paths.get(pathName);

        if (!Files.exists(rootPath)) {
            Files.createDirectories(rootPath);
        }

        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(fileName);

//        Files.write(rootPath.resolve(fileName), file.getBytes());
        Files.copy(file.getInputStream(), rootPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/files/preview-file/" + fileName)
                .toUriString();
        return FileMetadata.builder()
                .fileName(fileName)
                .fileType(file.getContentType())
                .fileUrl(fileUrl)
                .fileSize(file.getSize())
                .build();
    }

    @SneakyThrows
    @Override
    public Resource getFileByFileName(String fileName) {
        Path rootPath = Paths.get(pathName);
        return new InputStreamResource(Files.newInputStream(rootPath.resolve(fileName)));
    }
}
