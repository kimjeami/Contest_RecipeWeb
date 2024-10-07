package com.contest.recipe.member.dao;

import com.contest.recipe.member.mapper.MemberMapper;
import com.contest.recipe.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper mapper;

    public MemberVo login(MemberVo vo) {
        return mapper.login(vo);
    }
}
