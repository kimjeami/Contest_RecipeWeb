package com.contest.recipe.faq.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("faq")
public class FaqController {

    @GetMapping("main")
    public String FaqHome(){
        return "faq/home";
    }
}
