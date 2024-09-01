package com.contest.recipe.rank.service;


import com.contest.recipe.rank.dao.RankDao;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {

    private final RankDao dao;
    public List<RankVo> rankData(RankVo vo) {
        return dao.rankData(vo);
    }
}
