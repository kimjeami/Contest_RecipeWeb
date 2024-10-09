package com.contest.recipe.member.mapper;

import com.contest.recipe.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND  PWD = #{pwd}")
    MemberVo login(MemberVo vo);

    @Insert("INSERT INTO MEMBER(NO,ID,PWD,NICK,EMAIL,BIRTH,PHONE,POSTCODE,ADDRESS,ADDRESS_DETAIL,ADDRESS_EXTRA)\n" +
            "VALUES(SEQ_MEMBER_NO.NEXTVAL,#{id},#{pwd},#{nick},#{email},#{birth},#{phone},#{postcode},#{address},#{addressDetail},#{addressExtra})")
    int join(MemberVo memberVo);

    @Update("UPDATE MEMBER\n" +
            "SET PWD=#{pwd},NICK=#{nick},EMAIL=#{email},BIRTH=#{birth},PHONE=#{phone},POSTCODE=#{postcode},ADDRESS=#{address},ADDRESS_DETAIL=#{addressDetail},ADDRESS_EXTRA=#{addressExtra}\n" +
            "WHERE id = #{id}")
    int edit(MemberVo memberVo);

    @Update("UPDATE MEMBER " +
            "SET DEL_DATE = SYSDATE, DEL_YN = 'Y' " +
            "WHERE NO = #{no}")
    int delete(String no);

    @Select("SELECT * FROM MEMBER")
    List<MemberVo> list();
}
