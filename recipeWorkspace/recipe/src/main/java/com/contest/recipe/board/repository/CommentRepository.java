package com.contest.recipe.board.repository;

import com.contest.recipe.board.domain.Recipte_comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    public  void Commentsave(Recipte_comment recipte_comment);

    public List<Recipte_comment> Commentlist(int recipte_no);
}
