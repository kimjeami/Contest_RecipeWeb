package com.contest.recipe.admin.dao;


import com.contest.recipe.admin.mapper.AdminMapper;
import com.contest.recipe.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminDao {

    private final AdminMapper mapper;

    public AdminVo adminLogin(AdminVo vo) {
       return mapper.adminLogin(vo);
    }
}
