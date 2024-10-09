package com.contest.recipe.qna.service;

import com.contest.recipe.qna.dao.QnaDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QnaService {
    private final QnaDao dao;
}
