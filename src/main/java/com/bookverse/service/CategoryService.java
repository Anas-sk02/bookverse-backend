package com.bookverse.service;

import com.bookverse.entity.Book;
import com.bookverse.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    List<Book> getBooksByCategory(Long categoryId);

    Category saveCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);
}
