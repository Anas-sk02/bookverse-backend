package com.bookverse.service;

import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;

import java.util.List;
import org.springframework.data.domain.Page;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


public interface BookService {

    Page<BookResponseDto> getAllBooks(
            int page,
            int size,
            String sortBy,
            String direction);

    BookResponseDto getBookById(Long id);

    BookResponseDto saveBook(BookRequestDto dto);

    BookResponseDto updateBook(Long id, BookRequestDto dto);

    void deleteBook(Long id);



    List<BookResponseDto> searchBooks(String keyword);


    String uploadCoverImage(Long bookId, MultipartFile file);

    String uploadPdf(Long bookId, MultipartFile file);

    ResponseEntity<Resource> downloadCoverImage(Long bookId);

    ResponseEntity<Resource> downloadPdf(Long bookId);
}
