package com.contest.recipe.member.dao;

import com.contest.recipe.member.mapper.MemberMapper;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.member.vo.userCountVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {
    private final MemberMapper mapper;

    public MemberVo login(MemberVo vo) {
        return mapper.login(vo);
    }

    public int join(MemberVo memberVo) {
        return mapper.join(memberVo);
    }

    public int edit(MemberVo memberVo) {
        return mapper.edit(memberVo);
    }

    public int delete(String no) {
        return mapper.delete(no);
    }

    public List<MemberVo> list() {
        return mapper.list();
    }

    public userCountVo count(String no) {
        return mapper.count(no);
    }
}
