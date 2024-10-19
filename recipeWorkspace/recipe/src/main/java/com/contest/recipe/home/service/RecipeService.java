package com.contest.recipe.home.service;

import com.contest.recipe.home.dao.RecipeDao;
import com.contest.recipe.home.vo.RecipeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeDao dao;

    public List<RecipeVo> getRecentRecipes() {
        return dao.fetchRecentRecipes();
    }

    public List<RecipeVo> getRecentRecipesHit() {
        return dao.fetchRecentRecipesHit();
    }
}
