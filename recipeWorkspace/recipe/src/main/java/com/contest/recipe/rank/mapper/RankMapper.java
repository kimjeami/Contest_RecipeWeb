package com.contest.recipe.rank.mapper;


import com.contest.recipe.rank.vo.RankVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RankMapper {

    @Select("""
            SELECT *
            FROM RANK_PERMISSION
            """)
    List<RankVo> rankData(RankVo vo);
}
