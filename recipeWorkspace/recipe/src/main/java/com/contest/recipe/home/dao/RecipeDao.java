package com.contest.recipe.home.dao;

import com.contest.recipe.home.mapper.RecipeMapper;
import com.contest.recipe.home.vo.RecipeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RecipeDao {
    private final RecipeMapper mapper;

    public List<RecipeVo> fetchRecentRecipes() {
        return mapper.selectRecentRecipes();
    }

    public List<RecipeVo> fetchRecentRecipesHit() {
        return mapper.selectRecentRecipesHit();
    }

    public int favorite(String recipteNo) {
        return mapper.favorite(recipteNo);
    }

    public void favoriteInsert(String recipteNo, String no) {
        mapper.favoriteInsert(recipteNo,no);
    }

    public void favoriteDelete(String recipteNo, String no) {
        mapper.favoriteDelete(recipteNo,no);
    }
}
