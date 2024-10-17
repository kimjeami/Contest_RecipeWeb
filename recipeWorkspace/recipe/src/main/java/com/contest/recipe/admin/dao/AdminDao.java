package com.contest.recipe.admin.dao;


import com.contest.recipe.admin.mapper.AdminMapper;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminDao {

    private final AdminMapper mapper;

    public AdminVo adminLogin(AdminVo vo) {
       return mapper.adminLogin(vo);
    }

    public List<RankVo> adminRankData(AdminVo vo) {
        return mapper.adminRankData(vo);
    }

    public List<MemberVo> userData(MemberVo vo) {
        return mapper.userData(vo);
    }
}
