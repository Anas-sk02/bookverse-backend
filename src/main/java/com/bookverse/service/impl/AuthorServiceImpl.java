package com.bookverse.service.impl;

import com.bookverse.entity.Author;
import com.bookverse.entity.Book;
import com.bookverse.repository.AuthorRepository;
import com.bookverse.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }


    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Author not found"));
    }


    @Override
    public List<Book> getBooksByAuthor(Long authorId) {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        return author.getBooks();
    }
}
