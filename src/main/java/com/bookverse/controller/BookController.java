package com.bookverse.controller;

import com.bookverse.entity.Book;
import com.bookverse.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {

        return bookService.getBookById(id);

    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {

        return bookService.saveBook(book);

    }


    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book book) {

        return bookService.updateBook(id, book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {

        bookService.deleteBook(id);

    }

}
