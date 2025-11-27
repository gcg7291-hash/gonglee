package com.example.gonglee.service;

import com.example.gonglee.entity.Question;
import com.example.gonglee.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionService {
    
    private final QuestionRepository questionRepository;
    
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
    
    public Question createQuestion(String title, String optionA, String optionB) {
        Question question = Question.builder()
                .title(title)
                .optionA(optionA)
                .optionB(optionB)
                .build();
        return questionRepository.save(question);
    }
    
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("질문을 찾을 수 없습니다: " + id));
    }
    
    public Question getRandomQuestion() {
        return questionRepository.findRandomQuestion()
                .orElseThrow(() -> new IllegalArgumentException("질문이 없습니다"));
    }
}
