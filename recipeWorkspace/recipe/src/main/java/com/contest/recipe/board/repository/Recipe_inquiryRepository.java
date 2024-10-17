package com.contest.recipe.board.repository;

import com.contest.recipe.board.domain.Recipe_inquiry;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Recipe_inquiryRepository {

    public void inquirysave(Recipe_inquiry recipe_inquiry);

    public List<Recipe_inquiry> inquirylist(int write_no);

    public  List<Recipe_inquiry> answerlist(int awnser_no);

    public  Recipe_inquiry inquirydetail(int recipte_no, int write_no, int awnser_no);

    public  void answer(Recipe_inquiry recipe_inquiry);
}
