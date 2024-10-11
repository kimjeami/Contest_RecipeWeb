package com.contest.recipe.admin.dao;


import com.contest.recipe.admin.mapper.NotionMapper;
import com.contest.recipe.admin.vo.notionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NotionDao {

    private final NotionMapper mapper;

    public List<notionVo> notionData(notionVo vo) {
        return mapper.notionData(vo);
    }
}
