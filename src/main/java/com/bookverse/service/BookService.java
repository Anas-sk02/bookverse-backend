package com.bookverse.service;

import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;

import java.util.List;

public interface BookService {

    List<BookResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto saveBook(BookRequestDto dto);

    BookResponseDto updateBook(Long id, BookRequestDto dto);

    void deleteBook(Long id);
}
