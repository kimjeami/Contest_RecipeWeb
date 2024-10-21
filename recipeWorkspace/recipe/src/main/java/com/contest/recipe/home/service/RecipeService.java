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

    public boolean favorite(String recipteNo) {
        return dao.favorite(recipteNo)==0;
    }


    public void favoriteInsert(String recipteNo, String no) {
        dao.favoriteInsert(recipteNo,no);
    }

    public void favoriteDelete(String recipteNo, String no) {
        dao.favoriteDelete(recipteNo,no);
    }
}
