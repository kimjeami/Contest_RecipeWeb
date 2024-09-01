package com.contest.recipe.rank.dao;


import com.contest.recipe.rank.mapper.RankMapper;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RankDao {

    private final RankMapper mapper;

    public List<RankVo> rankData(RankVo vo) {
        return mapper.rankData(vo);
    }
}
