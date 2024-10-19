package com.contest.recipe.member.service;

import com.contest.recipe.member.dao.MemberDao;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.member.vo.userCountVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao dao;

    public MemberVo login(MemberVo vo) {
        return dao.login(vo);
    }

    public int join(MemberVo memberVo) {
        return dao.join(memberVo);
    }

    public int edit(MemberVo memberVo) {
        return dao.edit(memberVo);
    }

    public int delete(String no) {
        return dao.delete(no);
    }

    public List<MemberVo> list() {
        return dao.list();
    }

    public userCountVo count(String no) {
        return dao.count(no);
    }
}
