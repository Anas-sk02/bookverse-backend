package com.bookverse.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity      //
@Table(name = "authors")    //Database Table → Java Object Mapping ki.  ORM (Object Relational Mapping)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Book> books;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Book> getBooks() {
        return books;
    }
}
