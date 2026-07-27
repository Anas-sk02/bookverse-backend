package com.bookverse.controller;

import com.bookverse.entity.Book;
import com.bookverse.service.BookService;
import org.springframework.web.bind.annotation.*;
import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return bookService.getAllBooks();
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


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

    }

}
