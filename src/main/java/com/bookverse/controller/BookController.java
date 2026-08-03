package com.bookverse.controller;

import com.bookverse.entity.Book;
import com.bookverse.service.BookService;
import org.springframework.web.bind.annotation.*;
import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Page<BookResponseDto> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return bookService.getAllBooks(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookResponseDto saveBook(@Valid @RequestBody BookRequestDto dto) {
        return bookService.saveBook(dto);
    }


    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id,
                                      @Valid @RequestBody BookRequestDto dto){
        return bookService.updateBook(id, dto);
    }


    @DeleteMapping("/{id}")                          //koi bhi id ke liye
    public void deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

    }


    @GetMapping("/search")                //search api controller fir service fir repository DB then back
    public List<BookResponseDto> searchBooks(
            @RequestParam String keyword) {

        return bookService.searchBooks(keyword);
    }


    @PostMapping("/{id}/cover")
    public String uploadCoverImage(

            @PathVariable Long id,

            @RequestParam("file")
            MultipartFile file){

        return bookService.uploadCoverImage(id,file);
    }

}
