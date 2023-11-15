package com.northwind.api.services.impl;

import com.northwind.api.services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file.upload-dir}")
    private String uploadDir;


    @Override
    public List<String> storeFiles(List<MultipartFile> files) throws IOException {
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : files) {
            String fileName = storeFile(file);
            fileNames.add(fileName);
        }

        return fileNames;
    }
    @Override
    public String storeFile(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get("src", "main", "resources", uploadDir).toAbsolutePath().normalize();
        File targetFile = new File(uploadPath.toString(), fileName);
        file.transferTo(targetFile);
        return fileName;
    }
}
