package com.example.controller;

import com.example.model.Author;
import com.example.model.Tutorial;
import com.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @QueryMapping
    public List<Author> findAllAuthors(){
        return this.authorService.findAllAuthors();
    }

    @MutationMapping
    public Author createAuthor(@Argument String name, @Argument Integer age){
        return this.authorService.createAuthor(name, age);
    }
}
