package com.contest.recipe.admin.mapper;


import com.contest.recipe.admin.vo.notionVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotionMapper {

    @Select("""
            SELECT NO,TITLE,CONTENT,HIT,ENROLL_DATE as enrollDate, MODIFY_DATE as modifyDate, DEL_YN as delYn
            FROM NOTION
            """)
    List<notionVo> notionData(notionVo vo);


    @Select("""
            SELECT TITLE,CONTENT,HIT,TO_CHAR(ENROLL_DATE,'YYYY.MM.DD') as enrollDate, TO_CHAR(MODIFY_DATE,'YYYY.MM.DD') as modifyDate, DEL_YN as delYn
            FROM NOTION
            WHERE no = #{no}
            """)
    notionVo notionDetailData(notionVo vo);
}