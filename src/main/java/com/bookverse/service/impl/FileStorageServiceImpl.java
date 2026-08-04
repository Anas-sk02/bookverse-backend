package com.bookverse.service.impl;

import com.bookverse.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private static final String UPLOAD_DIR = "uploads/covers/";

    private static final String PDF_UPLOAD_DIR = "uploads/pdfs/";

    @Override
    public String uploadCoverImage(MultipartFile file) {

        try {

            Path uploadPath = Paths.get(UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName =
                    UUID.randomUUID()
                            + "_"
                            + file.getOriginalFilename();

            Path filePath =
                    uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return fileName;

        } catch (IOException e) {

            throw new RuntimeException(
                    "Image upload failed"
            );
        }

    }


    @Override
    public String uploadPdf(MultipartFile file) {

        try {

            Path uploadPath = Paths.get(PDF_UPLOAD_DIR);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String fileName =
                    UUID.randomUUID() + "_" + file.getOriginalFilename();

            Path filePath = uploadPath.resolve(fileName);

            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return fileName;

        } catch (IOException e) {

            throw new RuntimeException("PDF upload failed");
        }
    }
}
