package com.contest.recipe.member.service;

import com.contest.recipe.home.vo.RecipeVo;
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

    public List<RecipeVo> getMyRecipes(String no) {
        return dao.getMyRecipes(no);
    }

    public List<MemberVo> getFollowerList(String no) {
        return dao.getFollowerList(no);
    }

    public List<MemberVo> getFollowingList(String no) {
        return dao.getFollowingList(no);
    }

    public void followMember(String no, String memberNo) {
        System.out.println("no = " + no);
        System.out.println("memberNo = " + memberNo);
        dao.followMember(no,memberNo);
    }

    public void unfollowMember(String no, String memberNo) {
        dao.unfollowMember(no,memberNo);
    }

    public boolean checkIdAvailability(String id) {

        return dao.countById(id) == 0;
    }


    public boolean updatePassword(String id, String newPwd) {
        int result = dao.updatePassword(id, newPwd);
        return result > 0;
    }
}
