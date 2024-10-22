package com.contest.recipe.faq.mapper;

import com.contest.recipe.admin.vo.FaqVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FaqMapper {

    @Select("""
            SELECT  NO, TITLE, CONTENT, DEL_YN as delYn
            FROM FAQ
            WHERE NO = #{no}
            """)
    FaqVo faqDataOne(FaqVo vo);
}
