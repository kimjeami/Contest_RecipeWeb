package com.contest.recipe.admin.dao;

import com.contest.recipe.admin.mapper.QnaRequestMapper;
import com.contest.recipe.admin.vo.QnaRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * QNA_REQUEST DAO
 */
@Repository
@RequiredArgsConstructor
public class QnaRequestDao {

    private final QnaRequestMapper qnaRequestMapper;

    // 기본 CRUD
    public Boolean insert_rowAll(QnaRequestVo vo) { return qnaRequestMapper.insert_rowAll(vo); }

    public QnaRequestVo select_rowSpecific_all(Integer qnaRequestNo) { return qnaRequestMapper.select_rowSpecific_all(qnaRequestNo); }

    public Integer update_rowSpecific_all(QnaRequestVo vo) { return qnaRequestMapper.update_rowSpecific_all(vo); }

//    public

    /**
     * 관리자 메인페이지 출력용
     * @return
     */
    public List<HashMap<String, Object>> select_recentTen() { return qnaRequestMapper.select_recentTen(); }

}
