package com.contest.recipe.home.mapper;

import com.contest.recipe.home.vo.RecipeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecipeMapper {
    @Select("""
        SELECT * FROM (
            SELECT 
                R.RECIPTE_NO,
                R.TITLE,
                R.THUMBNAIL,
                R.WRITE_NAME,
                COALESCE(AVG(RC.SCOPE), 0) AS AVERAGE_SCOPE 
            FROM 
                RECIPE R
            FULL JOIN 
                RECIPTE_COMMENT RC ON R.RECIPTE_NO = RC.RECIPTE_NO
            GROUP BY 
                R.RECIPTE_NO, R.TITLE, R.THUMBNAIL, R.WRITE_NAME
            ORDER BY 
                R.RECIPTE_NO DESC
        ) WHERE ROWNUM <= 10
    """)
    List<RecipeVo> selectRecentRecipes();

    @Select("SELECT * FROM (\n" +
            "    SELECT \n" +
            "        R.RECIPTE_NO,\n" +
            "        R.TITLE,\n" +
            "        R.THUMBNAIL,\n" +
            "        R.WRITE_NAME,\n" +
            "        COALESCE(AVG(RC.SCOPE), 0) AS AVERAGE_SCOPE \n" +
            "    FROM \n" +
            "        RECIPE R\n" +
            "    FULL JOIN \n" +
            "        RECIPTE_COMMENT RC ON R.RECIPTE_NO = RC.RECIPTE_NO\n" +
            "    GROUP BY \n" +
            "        R.RECIPTE_NO, R.TITLE, R.THUMBNAIL, R.WRITE_NAME\n" +
            "    ORDER BY \n" +
            "        AVERAGE_SCOPE DESC,\n" +
            "         R.RECIPTE_NO DESC\n" +
            ") WHERE ROWNUM <= 10")
    List<RecipeVo> selectRecentRecipesHit();
}
