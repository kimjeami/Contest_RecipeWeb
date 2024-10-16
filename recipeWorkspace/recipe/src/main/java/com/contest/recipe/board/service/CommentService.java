package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Recipte_comment;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface CommentService {

    public void write(HttpServletRequest request);

    public List<Recipte_comment> list(int recipte_no );
}
