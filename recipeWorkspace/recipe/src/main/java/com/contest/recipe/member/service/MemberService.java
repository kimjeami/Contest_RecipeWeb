package com.contest.recipe.member.service;

import com.contest.recipe.member.dao.MemberDao;
import com.contest.recipe.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao dao;

    public MemberVo login(MemberVo vo) {
        return dao.login(vo);
    }
}
