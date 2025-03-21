package ru.vedrova.domain.repo;

import org.springframework.stereotype.Repository;
import ru.vedrova.domain.model.OpenQuestionCard;

import java.util.List;
import java.util.Optional;


public interface QuestionRepository {
    List<OpenQuestionCard> findAll();
    Optional<OpenQuestionCard> findById(Long id);
    void add(OpenQuestionCard task);
    void update(OpenQuestionCard task);
    void remove(Long id);
}
