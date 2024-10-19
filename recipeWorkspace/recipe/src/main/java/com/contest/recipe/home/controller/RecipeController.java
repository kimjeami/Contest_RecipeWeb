package com.contest.recipe.home.controller;

import com.contest.recipe.home.service.RecipeService;
import com.contest.recipe.home.vo.RecipeVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("recipe")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService service;
    //레시피 홈화면
    @GetMapping
    public String m01(HttpServletRequest request, Model model){
        List<RecipeVo> recipeList = service.getRecentRecipes();
        model.addAttribute("recipeList", recipeList);

        List<RecipeVo> recipeListHit = service.getRecentRecipesHit();
        model.addAttribute("recipeListHit", recipeListHit);

        return "recipe";
    }
}
