package com.bookverse.service;

import com.bookverse.entity.Author;
import com.bookverse.entity.Book;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthorById(Long id);

    List<Book> getBooksByAuthor(Long authorId);

}
