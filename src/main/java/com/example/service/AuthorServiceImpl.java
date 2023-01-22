package com.example.service;

import com.example.exceptions.AuthorNotFoundException;
import com.example.model.Author;
import com.example.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        return this.authorRepository.save(author);
    }

    @Override
    public Author findAuthorById(Long id) {
        Optional<Author> optionalAuthor = this.authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            throw new AuthorNotFoundException();
        }
    }
}
