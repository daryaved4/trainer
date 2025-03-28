package ru.vedrova.gui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vedrova.domain.service.QuestionService;
import ru.vedrova.gui.config.SpringConfig;
import ru.vedrova.gui.controller.MainController;


import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        QuestionService questionService = context.getBean(QuestionService.class);
        SwingUtilities.invokeLater(new MainController(questionService));
    }
}