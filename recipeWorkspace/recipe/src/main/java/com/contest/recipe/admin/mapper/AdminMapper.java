package com.contest.recipe.admin.mapper;


import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.rank.vo.RankVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("""
            SELECT *
            FROM ADMIN
            WHERE ADMIN_ID = #{adminId} AND ADMIN_PWD= #{adminPwd}
            """)
    AdminVo adminLogin(AdminVo vo);

    @Select("""
            SELECT ADMIN_NO, RANK_NO
            FROM RANK_PERMISSION
            WHERE ADMIN_NO = #{adminNo}
            """)
    List<RankVo> adminRankData(AdminVo vo);
}
