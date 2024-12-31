package com.lagger.quizapp.service;

import com.lagger.quizapp.dao.QuestionDao;
import com.lagger.quizapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> saveQuestions(List<Question> hardcodedQuestions) {
        return questionDao.saveAll(hardcodedQuestions);
    }

    public List<Question> getAllQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }
}
