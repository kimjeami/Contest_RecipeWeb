package com.contest.recipe.faq.controller;


import com.contest.recipe.admin.vo.FaqVo;
import com.contest.recipe.faq.service.FaqService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("faq")
@RequiredArgsConstructor
public class FaqController {
    private final FaqService service;
    @GetMapping("home")
    public String faqHome(FaqVo vo, HttpServletRequest req){

        FaqVo vo1 = service.faqDataOne(vo);

        req.setAttribute("vo",vo1);

        return "faq/faqHome";
    }
}
