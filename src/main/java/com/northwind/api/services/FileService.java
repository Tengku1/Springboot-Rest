package com.northwind.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> storeFiles(List<MultipartFile> files) throws IOException;

    String storeFile(MultipartFile file) throws IOException;
}
