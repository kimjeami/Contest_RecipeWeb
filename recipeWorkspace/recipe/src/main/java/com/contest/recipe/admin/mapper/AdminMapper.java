package com.contest.recipe.admin.mapper;


import com.contest.recipe.admin.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("""
            SELECT *
            FROM ADMIN
            WHERE ADMIN_ID = #{adminId} AND ADMIN_PWD= #{adminPwd}
            """)
    AdminVo adminLogin(AdminVo vo);
}
