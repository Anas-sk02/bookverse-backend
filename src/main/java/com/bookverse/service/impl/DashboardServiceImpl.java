package com.bookverse.service.impl;

import com.bookverse.dto.DashboardStatsDto;
import com.bookverse.repository.AuthorRepository;
import com.bookverse.repository.BookRepository;
import com.bookverse.repository.CategoryRepository;
import com.bookverse.repository.UserRepository;
import com.bookverse.service.DashboardService;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public DashboardServiceImpl(
            BookRepository bookRepository,
            AuthorRepository authorRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository) {

        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public DashboardStatsDto getDashboardStats() {

        return new DashboardStatsDto(

                bookRepository.count(),

                authorRepository.count(),

                categoryRepository.count(),

                userRepository.count()
        );
    }
}
