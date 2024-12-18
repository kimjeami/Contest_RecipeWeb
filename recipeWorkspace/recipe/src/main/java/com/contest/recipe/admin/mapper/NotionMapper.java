package com.contest.recipe.admin.mapper;


import com.contest.recipe.admin.vo.notionVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotionMapper {

    @Select("""
            SELECT NO,TITLE,CONTENT,HIT,ENROLL_DATE as enrollDate, MODIFY_DATE as modifyDate, DEL_YN as delYn
            FROM NOTION
            """)
    List<notionVo> notionData(notionVo vo);


    @Select("""
            SELECT NO, TITLE,CONTENT,HIT,TO_CHAR(ENROLL_DATE,'YYYY.MM.DD') as enrollDate, TO_CHAR(MODIFY_DATE,'YYYY.MM.DD') as modifyDate, DEL_YN as delYn
            FROM NOTION
            WHERE no = #{no}
            """)
    notionVo notionDetailData(notionVo vo);


    @Update("""
            UPDATE NOTION SET TITLE=#{title}, CONTENT = #{content}, MODIFY_DATE = CURRENT_TIMESTAMP WHERE NO = #{no}
            """)
    int notionModify(notionVo vo);


    @Update("""
            UPDATE NOTION SET DEL_YN = 'Y' WHERE NO = #{no}
            """)
    int notionTemporaryDelete(notionVo vo);


    @Delete(""" 
            DELETE NOTION
            WHERE NO = #{no}
            """)
    int notionDel(notionVo vo);

    @Insert("""
            INSERT INTO NOTION(NO,TITLE,CONTENT) VALUES(SEQ_NOTION_NO.NEXTVAL, #{title}, #{content})
            """)
    int notionInsert(notionVo vo);
}
