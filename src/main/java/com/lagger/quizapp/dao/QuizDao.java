package com.lagger.quizapp.dao;

import com.lagger.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
