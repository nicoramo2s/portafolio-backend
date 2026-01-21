package com.portfolio.my_portfolio_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("El archivo esta vacio");
        }

        String originalFileName = file.getOriginalFilename();
        String extension = "";
        if (originalFileName != null) {
            int dotIndex = originalFileName.lastIndexOf('.');
            if (dotIndex > 0) {
                extension = originalFileName.substring(dotIndex);
            }
        }
        String fileName = UUID.randomUUID().toString() + extension;

        // Creacion de la ruta
        Path filePath = Paths.get(uploadDir, fileName).normalize();

        //Copia del archivo al destino
        Files.copy(file.getInputStream(), filePath);

        //Retorno de la url relativo
        return "/img/projects/" + fileName;
    }
}
