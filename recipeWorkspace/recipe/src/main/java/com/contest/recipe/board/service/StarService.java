package com.contest.recipe.board.service;


import com.contest.recipe.board.domain.Star;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;


public interface StarService {

    public void write(HttpServletRequest request);

    public  void update(HttpServletRequest request);

    public Star getStar(int recipte_no, int member_no);
}
