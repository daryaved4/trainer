package ru.spbu.vedrova.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class OpenQuestionCardTest {

    private OpenQuestionCard card;

    @BeforeEach
    void setUp() {
        card = new OpenQuestionCard(1L,"What is Java?", "A programming language");
    }

    @Test
    @DisplayName("Должно выбрасываться исключение, если вопрос null")
    void shouldThrowExceptionWhenQuestionIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new OpenQuestionCard(1L,null, "answer"));
        assertEquals("question не может быть пустым", exception.getMessage());
    }

    @Test
    @DisplayName("Должно выбрасываться исключение, если вопрос пустая строка")
    void shouldThrowExceptionWhenQuestionIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new OpenQuestionCard(1L,"", "answer"));
        assertEquals("question не может быть пустым", exception.getMessage());
    }

    @Test
    @DisplayName("Должно выбрасываться исключение, если ожидаемый ответ null")
    void shouldThrowExceptionWhenExpectedAnswerIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new OpenQuestionCard(1L,"question", null));
        assertEquals("expectedAnswer не может быть пустым", exception.getMessage());
    }

    @Test
    @DisplayName("Должно выбрасываться исключение, если ожидаемый ответ пустая строка")
    void shouldThrowExceptionWhenExpectedAnswerIsEmpty() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new OpenQuestionCard(1L,"question", ""));
        assertEquals("expectedAnswer не может быть пустым", exception.getMessage());
    }

    @Test
    @DisplayName("Метод getQuestion() должен возвращать правильный вопрос")
    void shouldReturnCorrectQuestion() {
        assertEquals("What is Java?", card.getQuestion());
    }

    @Test
    @DisplayName("Метод checkAnswer() должен возвращать true при совпадении ответа без учета регистра и пробелов")
    void shouldReturnTrueWhenAnswerMatchesIgnoringCaseAndWhitespace() {
        assertTrue(card.checkAnswer("  a PROGRAMMING language  "));
    }

    @Test
    @DisplayName("Метод checkAnswer() должен возвращать false при несоответствии ответа")
    void shouldReturnFalseWhenAnswerDoesNotMatch() {
        assertFalse(card.checkAnswer("A scripting language"));
    }

    @Test
    @DisplayName("Метод checkAnswer() должен возвращать false, если переданный ответ null")
    void shouldReturnFalseWhenAnswerIsNull() {
        assertFalse(card.checkAnswer(null));
    }
}