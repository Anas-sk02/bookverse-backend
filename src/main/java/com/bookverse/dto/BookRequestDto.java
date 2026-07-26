package com.bookverse.dto;

public class BookRequestDto {

    // id nhi hai new book create karte waqt ID database generate karta hai

    private String title;

    private String description;

    private String language;

    private Integer pages;

    private Integer publishedYear;

    private Long authorId;

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
