package com.lagger.quizapp.controller;

import com.lagger.quizapp.models.Question;
import com.lagger.quizapp.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getAllQuestionByCategory(category);
    }

    @GetMapping("/populate")
    public ResponseEntity<List<Question>> populateDatabase() {
        List<Question> hardcodedQuestions = Arrays.asList(
                new Question("What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "Paris", "Easy", "Geography"),
                new Question("Who developed the theory of relativity?", "Newton", "Einstein", "Tesla", "Curie", "Einstein", "Medium", "Science"),
                new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Venus", "Jupiter", "Mars", "Easy", "Astronomy"),
                new Question("What is the chemical symbol for water?", "O2", "H2O", "CO2", "H2", "H2O", "Easy", "Chemistry"),
                new Question("What is the largest mammal?", "Elephant", "Blue Whale", "Shark", "Giraffe", "Blue Whale", "Hard", "Biology")
        );

        List<Question> savedQuestions = questionService.saveQuestions(hardcodedQuestions);
        return new ResponseEntity<>(savedQuestions, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
