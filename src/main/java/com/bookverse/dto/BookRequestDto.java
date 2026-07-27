package com.bookverse.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookRequestDto {

    // id nhi hai new book create karte waqt ID database generate karta hai

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 1000, message = "Description must be between 10 and 1000 characters")
    private String description;

    @NotBlank(message = "Language is required")
    private String language;

    @NotNull(message = "Pages are required")
    @Min(value = 1, message = "Pages must be greater than 0")
    private Integer pages;

    @NotNull(message = "Published year is required")
    @Min(value = 1900, message = "Published year must be greater than 1900")
    @Max(value = 2100, message = "Published year must be less than 2100")
    private Integer publishedYear;

    @NotNull(message = "Author is required")
    private Long authorId;

    @NotNull(message = "Category is required")
    private Long categoryId;

    private String coverImage;

    private String pdfUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    // No - arg constructor pehele obj banaga usmein arg nhi honge fir setter se values daalega @RequestBody

    public BookRequestDto() {

    }

    public BookRequestDto(String title, String description, String language, Integer pages, Integer publishedYear, Long authorId, Long categoryId, String coverImage, String pdfUrl) {
        this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.coverImage = coverImage;
        this.pdfUrl = pdfUrl;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
