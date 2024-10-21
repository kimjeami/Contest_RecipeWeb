package com.contest.recipe.home.controller;

import com.contest.recipe.home.service.RecipeService;
import com.contest.recipe.home.vo.RecipeVo;
import com.contest.recipe.member.vo.MemberVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //좋아요
    @PostMapping("/favorite")
    @ResponseBody
    public Map<String, Object> favorite(@RequestBody Map<String, String> param,HttpServletRequest request) {

        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        String recipte_no = param.get("recipte_no");
        boolean success = service.favorite(recipte_no);
        if(success){
            service.favoriteInsert(recipte_no,loginMemberVo.getNo());
        }else{
            service.favoriteDelete(recipte_no,loginMemberVo.getNo());
        }
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        return response;
    }
}
