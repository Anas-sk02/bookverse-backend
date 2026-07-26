package com.bookverse.service.impl;

import com.bookverse.dto.BookRequestDto;
import com.bookverse.dto.BookResponseDto;
import com.bookverse.entity.Author;
import com.bookverse.entity.Book;
import com.bookverse.entity.Category;
import com.bookverse.mapper.BookMapper;
import com.bookverse.repository.AuthorRepository;
import com.bookverse.repository.BookRepository;
import com.bookverse.repository.CategoryRepository;
import com.bookverse.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CategoryRepository categoryRepository) {

        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {

        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return BookMapper.toDto(book);
    }

    @Override
    public BookResponseDto saveBook(BookRequestDto dto) {

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Book book = BookMapper.toEntity(dto, author, category);

        Book savedBook = bookRepository.save(book);

        return BookMapper.toDto(savedBook);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto dto) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existingBook.setTitle(dto.getTitle());
        existingBook.setDescription(dto.getDescription());
        existingBook.setLanguage(dto.getLanguage());
        existingBook.setPages(dto.getPages());
        existingBook.setPublishedYear(dto.getPublishedYear());
        existingBook.setAuthor(author);
        existingBook.setCategory(category);

        Book updatedBook = bookRepository.save(existingBook);

        return BookMapper.toDto(updatedBook);
    }

    @Override
    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
