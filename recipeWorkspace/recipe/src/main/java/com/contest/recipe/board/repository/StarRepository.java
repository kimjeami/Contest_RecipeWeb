package com.contest.recipe.board.repository;

import com.contest.recipe.board.domain.Star;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StarRepository {

    public  void starsave(Star star);


    public  void starupdate(Star star);

    public  Star getStar(int recipte_no, int member_no);
}
