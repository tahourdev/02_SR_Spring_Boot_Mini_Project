package com.keanghor.java.miniproject.service.FIleService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImp implements FileService{
    private final Path path = Paths.get("src/main/resources/images");
    @Override
    public String saveFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        if (file.getOriginalFilename().contains(".png")
                || file.getOriginalFilename().contains(".pdf")
                || file.getOriginalFilename().contains(".jpeg")
                || file.getOriginalFilename().contains(".jpg")){
            fileName = UUID.randomUUID()+ "." + StringUtils.getFilenameExtension(fileName);
            if (!Files.exists(path)){Files.createDirectories(path);}
            Files.copy(file.getInputStream(), path.resolve(fileName));
            return fileName;
        }else {return "Upload Failed";}
    }

    @Override
    public Resource getFileByFileName(String fileName) throws IOException {
        Path path = Paths.get("src/main/resources/images/" + fileName);
        return new ByteArrayResource(Files.readAllBytes(path));

    }


}


