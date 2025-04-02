package com.contest.recipe.test.mapper;

import com.contest.recipe.test.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("SELECT * FROM MEMBER")
    List<TestVo> list();
}
