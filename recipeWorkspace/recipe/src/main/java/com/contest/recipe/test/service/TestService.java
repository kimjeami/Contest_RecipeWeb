package com.contest.recipe.test.service;

import com.contest.recipe.test.dao.TestDao;
import com.contest.recipe.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestDao dao;

    public List<TestVo> list() {
        return dao.list();
    }
}
