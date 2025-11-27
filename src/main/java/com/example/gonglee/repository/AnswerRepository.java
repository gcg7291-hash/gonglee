package com.example.gonglee.repository;

import com.example.gonglee.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    // Question 엔티티의 'question' 필드를 기준으로 Answer 목록을 조회하는 메서드
    List<Answer> findByQuestionId(Long questionId);
}