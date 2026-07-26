package com.bookverse.dto;

public class BookResponseDto {
    private Long id;

    private String title;

    private String description;

    private String language;

    private Integer pages;

    private Integer publishedYear;

    private String authorName;

    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BookResponseDto( ) {

    }

    public BookResponseDto(Long id, String title, String description, String language, Integer pages, Integer publishedYear, String authorName, String categoryName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.language = language;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.authorName = authorName;
        this.categoryName = categoryName;
    }



}
