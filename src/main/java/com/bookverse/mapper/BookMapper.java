package com.bookverse.mapper;

import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;
import com.bookverse.entity.Author;
import com.bookverse.entity.Book;
import com.bookverse.entity.Category;

public class BookMapper {

    // Entity -> Response DTO
    public static BookResponseDto toDto(Book book) {

        BookResponseDto dto = new BookResponseDto();

        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setLanguage(book.getLanguage());
        dto.setPages(book.getPages());
        dto.setPublishedYear(book.getPublishedYear());

        dto.setAuthorName(book.getAuthor().getName());
        dto.setCategoryName(book.getCategory().getName());

        return dto;
    }

    // Request DTO -> Entity
    public static Book toEntity(BookRequestDto dto,
                                Author author,
                                Category category) {

        Book book = new Book();

        book.setTitle(dto.getTitle());
        book.setDescription(dto.getDescription());
        book.setLanguage(dto.getLanguage());
        book.setPages(dto.getPages());
        book.setPublishedYear(dto.getPublishedYear());

        book.setAuthor(author);
        book.setCategory(category);

        book.setCoverImage(dto.getCoverImage());
        book.setPdfUrl(dto.getPdfUrl());

        return book;
    }
}
