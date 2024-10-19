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

    public notionVo notionDetailData(notionVo vo) {
        return mapper.notionDetailData(vo);
    }

    public int notionModify(notionVo vo) {
        return mapper.notionModify(vo);
    }

    public int notionTemporaryDelete(notionVo vo) {
        return mapper.notionTemporaryDelete(vo);
    }

    public int notionDel(notionVo vo) {
        return mapper.notionDel(vo);
    }

    public int notionInsert(notionVo vo) {
        return mapper.notionInsert(vo);
    }
}
