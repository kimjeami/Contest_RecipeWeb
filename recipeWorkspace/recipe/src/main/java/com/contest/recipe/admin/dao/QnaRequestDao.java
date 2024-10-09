package com.contest.recipe.admin.dao;

import com.contest.recipe.admin.mapper.QnaRequestMapper;
import com.contest.recipe.admin.vo.QnaRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * QNA_REQUEST DAO
 */
@Repository
@RequiredArgsConstructor
public class QnaRequestDao {

    private final QnaRequestMapper qnaRequestMapper;

    public Boolean insert_rowAll(QnaRequestVo vo) { return qnaRequestMapper.insert_rowAll(vo); }

    public QnaRequestVo select_rowSpecific_all(Integer qnaRequestNo) { return qnaRequestMapper.select_rowSpecific_all(qnaRequestNo); }

    public Integer update_rowSpecific_all(QnaRequestVo vo) { return qnaRequestMapper.update_rowSpecific_all(vo); }

//    public

}
