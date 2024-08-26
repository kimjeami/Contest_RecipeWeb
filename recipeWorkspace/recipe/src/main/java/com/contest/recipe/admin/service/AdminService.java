package com.contest.recipe.admin.service;


import com.contest.recipe.admin.dao.AdminDao;
import com.contest.recipe.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;


    public AdminVo adminLogin(AdminVo vo) {
        return dao.adminLogin(vo);
    }
}
