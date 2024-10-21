package com.contest.recipe.admin.service;


import com.contest.recipe.admin.dao.AdminDao;
import com.contest.recipe.admin.dao.QnaRequestDao;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.admin.vo.QnaRequestVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao dao;
    private final QnaRequestDao qnaReqDao;

    public AdminVo adminLogin(AdminVo vo) {
        return dao.adminLogin(vo);
    }

    public List<RankVo> adminRankData(AdminVo vo) {
        return dao.adminRankData(vo);
    }

    public List<MemberVo> userData(MemberVo vo) {
        return dao.userData(vo);
    }

    /**
     * 어드민 홈페이지 로드 <br>
     * 최근 Q&A, 신고, 가입자 각 10개 가져오기
     * <br><br>
     * 최근 신고, 가입자는 확인 필요해서 미뤄둠
     * @param model 값 적재용
     */
    public void loadAdminHome(Model model) {
        List<HashMap<String, Object>> qna;  // 최근 Q&A 요청 관련 10행
        // 신고는 차후에
//        List<MemberVo> member; // 최근 가입자 10행

        /*
        *  메모 - Mybatis는 조회 실패시 List<> 의 경우 빈 List 객체와 예외를 던지고
        * 단일 객체의 경우 null을 던진다고 함
        * 나중에 신고 넣을때 꼬일까봐 적어둠
        * 출처는 빙코파일럿
        * */

        // 가져오기
        try {
            qna = qnaReqDao.select_recentTen(); // QNA_REQUEST_STATUS 가 0(요청중 - 접수 안됨) 인 최근 Q&A 10개
        } catch(Exception e) {
            // 조회 실패시 출력, model에 결과 삽입 후 메서드를 종료
            e.printStackTrace();
            System.out.println("AdminService - loadAdminHome() 오류");
            model.addAttribute("isLoadFailed", true);
            return;
        }

        // 비어있는지 체크 - 값 삽입
        //Q&A
        if(qna.isEmpty()) {
            model.addAttribute("isQnaEmptyResult", true);
        } else {
            model.addAttribute("qnaList", qna);
        }

        //신고, 최근가입자 임시처리
        model.addAttribute("isReportEmptyResult", true);
        model.addAttribute("isRecentRegiEmptyResult", true);
    }
}
