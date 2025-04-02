package com.contest.recipe.test.dao;

import com.contest.recipe.test.mapper.TestMapper;
import com.contest.recipe.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TestDao {
    private final TestMapper mapper;

    public List<TestVo> list() {
        return mapper.list();
    }
}
