package com.contest.recipe.member.mapper;

import com.contest.recipe.member.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND  PWD = #{pwd}")
    MemberVo login(MemberVo vo);
}
