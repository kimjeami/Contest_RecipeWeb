package com.contest.recipe.admin.service;


import com.contest.recipe.admin.dao.NotionDao;
import com.contest.recipe.admin.vo.notionVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotionService {
    private final NotionDao dao;

    public List<notionVo> notionData(notionVo vo) {
        return dao.notionData(vo);
    }

    public notionVo notionDetailData(notionVo vo) {
        return dao.notionDetailData(vo);
    }

    public int notionModify(notionVo vo) {
        return dao.notionModify(vo);
    }
}
