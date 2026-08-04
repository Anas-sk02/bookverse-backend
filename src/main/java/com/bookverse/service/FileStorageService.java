package com.bookverse.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String uploadCoverImage(MultipartFile file);

    String uploadPdf(MultipartFile file);

}
