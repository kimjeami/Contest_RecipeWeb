package com.contest.recipe.qna.controller;

import com.contest.recipe.qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("qna")
@RequiredArgsConstructor
public class QnaController {
    private final QnaService service;
}
