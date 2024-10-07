package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Recipte_comment;

import java.util.List;

public interface CommentService {

    public void write(int recipte_no , String answer, String member_name, int scope);

    public List<Recipte_comment> list(int recipte_no );
}
