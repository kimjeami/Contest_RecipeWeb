package com.contest.recipe.board.repository;

import com.contest.recipe.board.domain.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BoardRepository {

    public void Recipesave(Recipe recipe);



    public  int countRecipe(int category,String keyword);

    public List<Recipe> recipeList(int category,String keyword,int from, int rows);



    public Recipe recipeDetail(int recipte_no);

    public  void modify(Recipe recipe);

    public  int recipeDelete(int recipte_no);

    public  Recipe recipeInquiry(int recipte_no);

}
