package com.example.service;

import com.example.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();

    Author createAuthor(String name, Integer age);

    Author findAuthorById(Long id);
}
