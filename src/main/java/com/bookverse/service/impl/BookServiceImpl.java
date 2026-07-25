package com.bookverse.service.impl;

import com.bookverse.entity.Book;
import com.bookverse.repository.BookRepository;
import com.bookverse.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {

        return bookRepository.findById(id).orElse(null);

    }

    @Override
    public Book saveBook(Book book) {

        return bookRepository.save(book);

    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook == null) {
            return null;
        }

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setLanguage(updatedBook.getLanguage());
        existingBook.setPages(updatedBook.getPages());
        existingBook.setPublishedYear(updatedBook.getPublishedYear());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setCategory(updatedBook.getCategory());

        return bookRepository.save(existingBook);
    }



    @Override
    public void deleteBook(Long id) {

        bookRepository.deleteById(id);

    }
}
