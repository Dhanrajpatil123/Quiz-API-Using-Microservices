package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    // create

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return this.quizService.addQuiz(quiz);
    }


    // get all quiz

    @GetMapping
    public List<Quiz> getQuizzes(){
        return this.quizService.getQuizzes();
    }


    // get single  quiz

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable Long quizId){
        return this.quizService.getQuizById(quizId);
    }

}
