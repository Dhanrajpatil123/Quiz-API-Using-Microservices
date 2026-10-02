package com.question.services.implementation;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImplementation implements QuestionService {

    private final QuestionRepository questionRepository;


    @Override
    public Question createQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Integer id) {
        return this.questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getAllQuestionsByQuizId(Long quizId) {
        return this.questionRepository.findByQuizId(quizId);
    }
}
