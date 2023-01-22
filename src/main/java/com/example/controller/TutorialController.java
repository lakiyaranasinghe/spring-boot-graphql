package com.example.controller;

import com.example.model.Author;
import com.example.model.Tutorial;
import com.example.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TutorialController {
    private final TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @QueryMapping
    public List<Tutorial> findAllTutorials() {
        return this.tutorialService.findAllTutorials();
    }

    @QueryMapping
    public Author author(Tutorial tutorial) {
        return tutorialService.findAuthorByTutorial(tutorial);
    }

    @MutationMapping
    public Tutorial createTutorial(@Argument String title, @Argument String description, @Argument Long authorId) {
        return this.tutorialService.createTutorial(title, description, authorId);
    }
}
