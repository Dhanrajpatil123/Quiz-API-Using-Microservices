package com.question.services;

import com.question.entities.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Question getQuestionById(Integer id);

    List<Question> getAllQuestionsByQuizId(Long quizId);
}
