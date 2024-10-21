package com.contest.recipe.home.mapper;

import com.contest.recipe.home.vo.RecipeVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecipeMapper {
    @Select("SELECT * FROM (\n" +
            "    SELECT \n" +
            "        R.RECIPTE_NO,\n" +
            "        R.TITLE,\n" +
            "        R.THUMBNAIL,\n" +
            "        R.WRITE_NAME,\n" +
            "        COALESCE(AVG(S.SCOPE), 0) AS AVERAGE_SCOPE \n" +
            "    FROM \n" +
            "        RECIPE R\n" +
            "    FULL JOIN \n" +
            "        RECIPTE_COMMENT RC ON R.RECIPTE_NO = RC.RECIPTE_NO\n" +
            "    FULL JOIN\n" +
            "        STAR S ON R.RECIPTE_NO = S.RECIPTE_NO\n" +
            "    GROUP BY \n" +
            "        R.RECIPTE_NO, R.TITLE, R.THUMBNAIL, R.WRITE_NAME\n" +
            "    ORDER BY\n" +
            "        R.RECIPTE_NO DESC\n" +
            ") WHERE ROWNUM <= 10")
    List<RecipeVo> selectRecentRecipes();

    @Select("SELECT * FROM (\n" +
            "    SELECT \n" +
            "        R.RECIPTE_NO,\n" +
            "        R.TITLE,\n" +
            "        R.THUMBNAIL,\n" +
            "        R.WRITE_NAME,\n" +
            "        COALESCE(AVG(S.SCOPE), 0) AS AVERAGE_SCOPE \n" +
            "    FROM \n" +
            "        RECIPE R\n" +
            "    FULL JOIN \n" +
            "        RECIPTE_COMMENT RC ON R.RECIPTE_NO = RC.RECIPTE_NO\n" +
            "    FULL JOIN\n" +
            "        STAR S ON R.RECIPTE_NO = S.RECIPTE_NO\n" +
            "    GROUP BY \n" +
            "        R.RECIPTE_NO, R.TITLE, R.THUMBNAIL, R.WRITE_NAME\n" +
            "    ORDER BY\n" +
            "        AVERAGE_SCOPE DESC,\n" +
            "        R.RECIPTE_NO DESC\n" +
            ") WHERE ROWNUM <= 10")
    List<RecipeVo> selectRecentRecipesHit();

    @Select("SELECT COUNT(*)\n" +
            "FROM STAR\n" +
            "WHERE RECIPE_NO=#{recipteNo}")
    int favorite(String recipteNo);

    @Insert("INSERT INTO FAVORITE(NO,RECIPTE_NO,MEMBER_NO)\n" +
            "VALUES(SEQ_FAVORITE_NO.NEXTVAL,#{recipteNo},#{no})")
    void favoriteInsert(String recipteNo, String no);

    @Delete("DELETE FAVORITE\n" +
            "WHERE RECIPTE_NO=#{recipteNo}\n" +
            "AND MEMBER_NO=#{no}")
    void favoriteDelete(String recipteNo, String no);
}
