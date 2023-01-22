package com.example.service;

import com.example.model.Author;
import com.example.model.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> findAllTutorials();

    Author findAuthorByTutorial(Tutorial tutorial);

    Tutorial createTutorial(String title, String description, Long authorId);
}
