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
}
