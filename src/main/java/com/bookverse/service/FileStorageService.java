package com.bookverse.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

public interface FileStorageService {

    String uploadCoverImage(MultipartFile file);

    String uploadPdf(MultipartFile file);

    Resource downloadCoverImage(String fileName);

    Resource downloadPdf(String fileName);

}
