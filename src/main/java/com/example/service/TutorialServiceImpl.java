package com.example.service;

import com.example.model.Author;
import com.example.model.Tutorial;
import com.example.repository.TutorialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService{
    private final TutorialRepository tutorialRepository;
    private final AuthorService authorService;

    public TutorialServiceImpl(TutorialRepository tutorialRepository, AuthorService authorService) {
        this.tutorialRepository = tutorialRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Tutorial> findAllTutorials() {
        return this.tutorialRepository.findAll();
    }

    @Override
    public Author findAuthorByTutorial(Tutorial tutorial) {
        Optional<Tutorial> optionalTutorial = this.tutorialRepository.findById(tutorial.getId());
        return optionalTutorial.map(Tutorial::getAuthor).orElse(null);
    }

    @Override
    public Tutorial createTutorial(String title, String description, Long authorId) {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle(title);
        tutorial.setDescription(description);
        Author author = this.authorService.findAuthorById(authorId);
        tutorial.setAuthor(author);
        this.tutorialRepository.save(tutorial);
        return tutorial;
    }
}
