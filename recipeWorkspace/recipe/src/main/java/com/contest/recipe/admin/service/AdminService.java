package com.contest.recipe.admin.service;


import com.contest.recipe.admin.dao.AdminDao;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;


    public AdminVo adminLogin(AdminVo vo) {
        return dao.adminLogin(vo);
    }

    public List<RankVo> adminRankData(AdminVo vo) {
        return dao.adminRankData(vo);
    }
}
