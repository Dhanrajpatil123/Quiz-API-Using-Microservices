package com.quiz.services.implementation;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuizServiceImplementation implements QuizService {

    private final QuizRepository quizRepository;

    private final QuestionClient questionClient;


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {

        List<Quiz>  quizzes = this.quizRepository.findAll();

        List<Quiz> newQuiz = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).toList();

        return newQuiz;
    }

    @Override
    public Quiz getQuizById(Long id) {

        Quiz quiz = this.quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Quiz found with id: " + id));

        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));

        return quiz;
    }
}
