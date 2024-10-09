package com.contest.recipe.board.repository;

import com.contest.recipe.board.domain.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardRepository {

    public void Recipesave(Recipe recipe);

    public List<Recipe> recipeList();

    public Recipe recipeDetail(int recipte_no);

    public  void modify(Recipe recipe);


}
