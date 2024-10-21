package com.contest.recipe.member.mapper;

import com.contest.recipe.home.vo.RecipeVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.member.vo.userCountVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND  PWD = #{pwd}")
    MemberVo login(MemberVo vo);

    @Insert("INSERT INTO MEMBER(NO,ID,PWD,NICK,EMAIL,BIRTH,PHONE,POSTCODE,ADDRESS,ADDRESS_DETAIL,ADDRESS_EXTRA)\n" +
            "VALUES(SEQ_MEMBER_NO.NEXTVAL,#{id},#{pwd},#{nick},#{email},#{birth},#{phone},#{postcode},#{address},#{addressDetail},#{addressExtra})")
    int join(MemberVo memberVo);

    @Update("UPDATE MEMBER\n" +
            "SET NICK=#{nick},EMAIL=#{email},BIRTH=#{birth},PHONE=#{phone},POSTCODE=#{postcode},ADDRESS=#{address},ADDRESS_DETAIL=#{addressDetail},ADDRESS_EXTRA=#{addressExtra}\n" +
            "WHERE no = #{no}")
    int edit(MemberVo memberVo);

    @Update("UPDATE MEMBER " +
            "SET DEL_DATE = SYSDATE, DEL_YN = 'Y' " +
            "WHERE NO = #{no}")
    int delete(String no);

    @Select("SELECT * FROM MEMBER")
    List<MemberVo> list();

    @Select("SELECT \n" +
            "    (SELECT COUNT(*) FROM FREIND WHERE FOLLOWER = #{no}) AS FOLLOWER_COUNT,\n" +
            "    (SELECT COUNT(*) FROM FREIND WHERE FOLLOWING = #{no}) AS FOLLOWING_COUNT,\n" +
            "    (SELECT COUNT(*) FROM RECIPE WHERE WRITE_NO = #{no}) AS RECIPE_COUNT\n" +
            "FROM DUAL")
    userCountVo count(String no);

    @Select("SELECT \n" +
            "    R.RECIPTE_NO,\n" +
            "    R.TITLE,\n" +
            "    R.THUMBNAIL,\n" +
            "    R.WRITE_NAME,\n" +
            "    COALESCE(AVG(S.SCOPE), 0) AS AVERAGE_SCOPE \n" +
            "FROM \n" +
            "    RECIPE R\n" +
            "FULL JOIN \n" +
            "    RECIPTE_COMMENT RC ON R.RECIPTE_NO = RC.RECIPTE_NO\n" +
            "FULL JOIN\n" +
            "        STAR S ON R.RECIPTE_NO = S.RECIPTE_NO\n" +
            "WHERE\n" +
            "    R.WRITE_NO = 1000  \n" +
            "GROUP BY \n" +
            "    R.RECIPTE_NO, R.TITLE, R.THUMBNAIL, R.WRITE_NAME\n" +
            "ORDER BY \n" +
            "    R.RECIPTE_NO DESC")
    List<RecipeVo> getMyRecipes(String no);

    @Select("SELECT NO,NICK,ID,EMAIL,PROFILE\n" +
            "FROM FREIND\n" +
            "JOIN MEMBER ON NO=FOLLOWING\n" +
            "WHERE FOLLOWER = #{no}\n" +
            "ORDER BY FREIND_NO DESC")
    List<MemberVo> getFollowerList(String no);

    @Select("SELECT NO,NICK,ID,EMAIL,PROFILE\n" +
            "FROM FREIND\n" +
            "JOIN MEMBER ON NO=FOLLOWER\n" +
            "WHERE FOLLOWING=#{no}\n" +
            "ORDER BY FREIND_NO DESC")
    List<MemberVo> getFollowingList(String no);

    @Insert("INSERT INTO FREIND(FREIND_NO,FOLLOWER,FOLLOWING)\n" +
            "VALUES(SEQ_FREIND_NO.NEXTVAL,#{memberNo},#{no})")
    void followMember(String no, String memberNo);

    @Delete("DELETE FROM FREIND\n" +
            "WHERE FOLLOWER = #{memberNo} AND FOLLOWING = #{no}")
    void unfollowMember(String no, String memberNo);

    @Select("SELECT COUNT(*)\n" +
            "FROM MEMBER\n" +
            "WHERE ID=#{id}")
    int countById(String id);

    @Update("UPDATE MEMBER SET PWD = #{newPwd} WHERE ID = #{id}")
    int updatePassword(@Param("id") String id, @Param("newPwd") String newPwd);
}
