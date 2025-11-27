package com.example.gonglee.controller;

import com.example.gonglee.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/answers")
    public String submitAnswer(@RequestParam Long questionId,
                               @RequestParam String answerText,
                               @RequestParam(required = false, defaultValue = "") String content) {

        // 1. AnswerService를 사용하여 답변 저장
        answerService.createAnswer(questionId, answerText, content);

        // 2. 답변 저장 후 질문 상세 페이지로 리다이렉트
        return "redirect:/questions/" + questionId;
    }
}