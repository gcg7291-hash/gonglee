package com.example.gonglee.service;

import com.example.gonglee.entity.Answer;
import com.example.gonglee.entity.Question;
import com.example.gonglee.repository.AnswerRepository;
import com.example.gonglee.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AnswerService {
    
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    
    public Answer createAnswer(Long questionId, String answerText, String content) {
        if (!("A".equals(answerText) || "B".equals(answerText))) {
            throw new IllegalArgumentException("answerText는 'A' 또는 'B'여야 합니다");
        }
        
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("질문을 찾을 수 없습니다: " + questionId));
        
        Answer answer = Answer.builder()
                .answerText(answerText)
                .content(content)
                .question(question)
                .build();
        
        return answerRepository.save(answer);
    }
}
