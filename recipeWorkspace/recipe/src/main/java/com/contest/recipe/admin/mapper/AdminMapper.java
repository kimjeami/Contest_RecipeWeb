package com.contest.recipe.admin.mapper;


import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.rank.vo.RankVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("""
            SELECT ADMIN_NO as adminNo, ADMIN_ID as adminId, ADMIN_PWD as adminPwd, ADMIN_IS_DELETED as adminIsDeleted
            FROM ADMIN
            WHERE ADMIN_ID = #{adminId} AND ADMIN_PWD= #{adminPwd}
            """)
    AdminVo adminLogin(AdminVo vo);

    @Select("""
            SELECT ADMIN_NO as adminNo, R.RANK_NO as rankNo, RANK_NAME as rankName
            FROM RANK_PERMISSION RP
            JOIN RANK R
            ON RP.RANK_NO = R.RANK_NO
            WHERE ADMIN_NO = #{adminNo}
            """)
    List<RankVo> adminRankData(AdminVo vo);

    @Select("""
            SELECT *
            FROM MEMBER
            """)
    List<MemberVo> userData(MemberVo vo);
}
