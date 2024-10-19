package com.contest.recipe.member.dao;

import com.contest.recipe.home.vo.RecipeVo;
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

    public List<RecipeVo> getMyRecipes(String no) {
        return mapper.getMyRecipes(no);
    }

    public List<MemberVo> getFollowerList(String no) {
        return mapper.getFollowerList(no);
    }

    public List<MemberVo> getFollowingList(String no) {
        return mapper.getFollowingList(no);
    }

    public void followMember(String no, String memberNo) {
        mapper.followMember(no,memberNo);
    }

    public void unfollowMember(String no, String memberNo) {
        mapper.unfollowMember(no,memberNo);
    }

    public int countById(String id) {
        return mapper.countById(id);
    }

    public int updatePassword(String id, String newPwd) {
        return mapper.updatePassword(id, newPwd);
    }
}
