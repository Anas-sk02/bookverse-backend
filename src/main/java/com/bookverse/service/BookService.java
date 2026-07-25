package com.bookverse.service;

import com.bookverse.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    // next
    Book getBookById(Long id);

    Book saveBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);

}
