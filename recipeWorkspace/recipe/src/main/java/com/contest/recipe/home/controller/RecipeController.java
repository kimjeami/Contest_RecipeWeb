package com.contest.recipe.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipe")
public class RecipeController {
    //레시피 홈화면
    @GetMapping
    public String m01(){
        return "recipe";
    }
}
