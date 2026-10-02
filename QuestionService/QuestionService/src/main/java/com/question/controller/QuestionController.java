package com.question.controller;


import com.question.entities.Question;
import com.question.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    // create question

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return this.questionService.createQuestion(question);
    }

    @GetMapping
    public List<Question> getAllQuestions() {
        return this.questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return this.questionService.getQuestionById(id);
    }


    // get all questions of specific quiz

    @GetMapping("/quiz/{quizId}")
    public List<Question> getAllQuestionsByQuizId(@PathVariable Long quizId) {
        return this.questionService.getAllQuestionsByQuizId(quizId);
    }

}
