package com.contest.recipe.qna.dao;

import com.contest.recipe.qna.mapper.QnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QnaDao {
    private final QnaMapper mapper;
}
